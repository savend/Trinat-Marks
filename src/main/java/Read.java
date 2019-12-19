import java.io.File;
import java.io.FileReader;

public class Read {


    /*-------METHODS------*/


    //read a Semester File
    public static SemesterInterface read(String file) throws Exception {
        FileReader fileReader = new FileReader(file);
        File fileW = new File(file);
        int i;
        String reader = "";
        String[] ModuleSplit;
        String[] SubjectSplit;
        String[] MarkSplit;
        String[] MarkAttributeSplit;

        //read the complete file
        while ((i = fileReader.read()) != -1) {
            reader = (reader + (char) i);
        }

        //Split at every new Module
        ModuleSplit = reader.split("Module=");

        SemesterInterface semester = new SemesterInterface(fileW);
        semester.setName(ModuleSplit[0].replaceAll("Semester=", ""));
        for (int l = 1; l < ModuleSplit.length; l++) {
            //Split at every new Subject
            SubjectSplit = ModuleSplit[l].split("\nSubject=");

            MarkSplit = SubjectSplit[0].split("\nMark=");
            //Split at every new semi-colon to have all Module information
            MarkAttributeSplit = MarkSplit[0].split(";");

            ModuleInterface moduleInterface = new ModuleInterface();
            moduleInterface.getModule().setMarkName(MarkAttributeSplit[0]);

            semester.getModuleInterfaceArrayList().add(moduleInterface);

            for (int p = 1; p < SubjectSplit.length; p++) {
                //Split at every new Mark
                MarkSplit = SubjectSplit[p].split("\nMark=");

                //Split at every new semi-colon to have all Subject information
                MarkAttributeSplit = MarkSplit[0].split(";");

                SubjectInterface subjectInterface = new SubjectInterface(moduleInterface.getModule());

                subjectInterface.getSubject().setMarkName(MarkAttributeSplit[0]);
                subjectInterface.getSubject().setCoefficient(Double.parseDouble(MarkAttributeSplit[1]));

                moduleInterface.getSubjectInterfaceArrayList().add(p - 1, subjectInterface);

                for (int j = 1; j < MarkSplit.length; j++) {
                    //Split at every new semi-colon to have all mark information
                    MarkAttributeSplit = MarkSplit[j].split(";");

                    Mark newMark = new Mark(MarkAttributeSplit[0], Double.parseDouble(MarkAttributeSplit[1]), Double.parseDouble(MarkAttributeSplit[2]));
                    MarkInterface markInterface = new MarkInterface(newMark, subjectInterface.getSubject(), false);

                    subjectInterface.getMarkInterfaceArrayList().add(j - 1, markInterface);
                }
                subjectInterface.generateVBox(subjectInterface.getMarkInterfaceArrayList());
            }
            moduleInterface.generateHBox(moduleInterface.getSubjectInterfaceArrayList());
        }
        semester.generateHBox(semester.getModuleInterfaceArrayList());


        fileReader.close();
        return semester;
    }

}
