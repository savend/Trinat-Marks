package sample;

import java.io.FileReader;

public class Read {


    /*-------METHODS------*/


    //read a Semester File
    public static SemesterInterface read() throws Exception {
        FileReader fileReader = new FileReader("data.txt");
        int i;
        String reader = "";
        String[] SubjectSplit;
        String[] ExamSplit;
        String[] MarkSplit;
        String[] MarkAttributeSplit;

        //read the complete file
        while ((i = fileReader.read()) != -1) {
            reader = (reader + (char) i);
        }

        //Split at every new Subject
        SubjectSplit = reader.split("\nSubject=");

        SemesterInterface semester = new SemesterInterface();
        for (int l = 1; l < SubjectSplit.length; l++) {
            //Split at every new Exam
            ExamSplit = SubjectSplit[l].split("\nExam=");

            MarkSplit = ExamSplit[0].split("\nMark=");
            //Split at every new semi-colon to have all Subject information
            MarkAttributeSplit = MarkSplit[0].split(";");

            SubjectInterface subjectInterface = new SubjectInterface();
            subjectInterface.getSubject().setMarkName(MarkAttributeSplit[0]);

            semester.getSubjectInterfaceArrayList().add(subjectInterface);

            for (int p = 1; p < ExamSplit.length; p++) {
                //Split at every new Mark
                MarkSplit = ExamSplit[p].split("\nMark=");

                //Split at every new semi-colon to have all Exam information
                MarkAttributeSplit = MarkSplit[0].split(";");

                ExamInterface examInterface = new ExamInterface(subjectInterface.getSubject());

                examInterface.getExam().setMarkName(MarkAttributeSplit[0]);
                examInterface.getExam().setCoefficient(Double.parseDouble(MarkAttributeSplit[1]));

                subjectInterface.getExamInterfaceArrayList().add(p - 1, examInterface);

                for (int j = 1; j < MarkSplit.length; j++) {
                    //Split at every new semi-colon to have all mark information
                    MarkAttributeSplit = MarkSplit[j].split(";");

                    Mark newMark = new Mark(MarkAttributeSplit[0], Double.parseDouble(MarkAttributeSplit[2]), Double.parseDouble(MarkAttributeSplit[1]));
                    MarkInterface markInterface = new MarkInterface(newMark, examInterface.getExam(), false);

                    examInterface.getMarkInterfaceArrayList().add(j - 1, markInterface);
                }
                examInterface.generateVBox(examInterface.getMarkInterfaceArrayList());
            }
            subjectInterface.generateHBox(subjectInterface.getExamInterfaceArrayList());
        }
        semester.generateHBox(semester.getSubjectInterfaceArrayList());


        fileReader.close();
        return semester;
    }

}
