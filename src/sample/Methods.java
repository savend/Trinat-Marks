package sample;

/**
 * TEST CLASS -- WILL BE REOMVE --
 **/

public class Methods { /*

    private static final int MARK_FR = 0;
    private static final int MARK_DE = 1;
    private static final int MARK_CH = 2;

    public static double [][] markTable = new double [][] { //markTable[value][language]
            {16.0, 1.0, 6.0},   //french //German //Swiss
            {15.9, 1.1, 5.9},
            {15.8, 1.1, 5.9},
            {15.7, 1.1, 5.9},
            {15.6, 1.2, 5.8},
            {15.5, 1.2, 5.8},
            {15.4, 1.2, 5.7},
            {15.3, 1.3, 5.7},
            {15.2, 1.3, 5.6},
            {15.1, 1.4, 5.6},
            {15.0, 1.4, 5.5},
            {14.9, 1.5, 5.5},
            {14.8, 1.5, 5.4},
            {14.7, 1.6, 5.4},
            {14.6, 1.6, 5.3},
            {14.5, 1.6, 5.3},
            {14.4, 1.6, 5.2},
            {14.3, 1.7, 5.2},
            {14.2, 1.7, 5.1},
            {14.1, 1.8, 5.1},
            {14.0, 1.8, 5.0},
            {13.9, 1.9, 5.0},
            {13.8, 1.9, 4.9},
            {13.7, 1.9, 4.9},
            {13.6, 2.0, 4.9},
            {13.5, 2.0, 4.8},
            {13.4, 2.0, 4.8},
            {13.3, 2.1, 4.8},
            {13.2, 2.1, 4.8},
            {13.1, 2.2, 4.7},
            {13.0, 2.2, 4.7},
            {12.9, 2.3, 4.7},
            {12.8, 2.3, 4.7},
            {12.7, 2.3, 4.6},
            {12.6, 2.4, 4.6},
            {12.5, 2.4, 4.6},
            {12.4, 2.4, 4.6},
            {12.3, 2.5, 4.5},
            {12.2, 2.5, 4.5},
            {12.1, 2.6, 4.5},
            {12.0, 2.6, 4.5},
            {11.9, 2.7, 4.4},
            {11.8, 2.7, 4.4},
            {11.7, 2.7, 4.4},
            {11.6, 2.8, 4.4},
            {11.5, 2.8, 4.3},
            {11.4, 2.8, 4.3},
            {11.3, 2.9, 4.3},
            {11.2, 2.9, 4.3},
            {11.1, 3.0, 4.2},
            {11.0, 3.0, 4.2},
            {10.9, 3.1, 4.2},
            {10.8, 3.2, 4.2},
            {10.7, 3.3, 4.1},
            {10.6, 3.4, 4.1},
            {10.5, 3.5, 4.1},
            {10.4, 3.6, 4.1},
            {10.3, 3.7, 4.0},
            {10.2, 3.8, 4.0},
            {10.1, 3.9, 4.0},
            {10.0, 4.0, 4.0},
            {9.9, 4.1, 3.9},
            {9.8, 4.1, 3.9},
            {9.7, 4.1, 3.9},
            {9.6, 4.1, 3.8},
            {9.5, 4.1, 3.8},
            {9.4, 4.1, 3.8},
            {9.3, 4.1, 3.7},
            {9.2, 4.1, 3.7},
            {9.1, 4.1, 3.7},
            {9.0, 4.1, 3.6},
            {8.9, 4.2, 3.6},
            {8.8, 4.2, 3.6},
            {8.7, 4.2, 3.5},
            {8.6, 4.2, 3.5},
            {8.5, 4.2, 3.5},
            {8.4, 4.2, 3.4},
            {8.3, 4.2, 3.4},
            {8.2, 4.2, 3.4},
            {8.1, 4.2, 3.3},
            {8.0, 4.2, 3.3},
            {7.9, 4.3, 3.3},
            {7.8, 4.3, 3.2},
            {7.7, 4.3, 3.2},
            {7.6, 4.3, 3.2},
            {7.5, 4.3, 3.1},
            {7.4, 4.3, 3.1},
            {7.3, 4.3, 3.1},
            {7.2, 4.3, 3.0},
            {7.1, 4.3, 3.0},
            {7.0, 4.3, 3.0},
            {6.9, 4.4, 3.0},
            {6.8, 4.4, 2.9},
            {6.7, 4.4, 2.9},
            {6.6, 4.4, 2.9},
            {6.5, 4.4, 2.9},
            {6.4, 4.4, 2.8},
            {6.3, 4.4, 2.8},
            {6.2, 4.4, 2.8},
            {6.1, 4.4, 2.8},
            {6.0, 4.4, 2.7},
            {5.9, 4.5, 2.7},
            {5.8, 4.5, 2.7},
            {5.7, 4.5, 2.7},
            {5.6, 4.5, 2.6},
            {5.5, 4.5, 2.6},
            {5.4, 4.5, 2.6},
            {5.3, 4.5, 2.6},
            {5.2, 4.5, 2.5},
            {5.1, 4.5, 2.5},
            {5.0, 4.5, 2.5},
            {4.9, 4.6, 2.4},
            {4.8, 4.6, 2.4},
            {4.7, 4.6, 2.4},
            {4.6, 4.6, 2.3},
            {4.5, 4.6, 2.3},
            {4.4, 4.6, 2.3},
            {4.3, 4.6, 2.3},
            {4.2, 4.6, 2.2},
            {4.1, 4.6, 2.2},
            {4.0, 4.6, 2.2},
            {3.9, 4.7, 2.1},
            {3.8, 4.7, 2.1},
            {3.7, 4.7, 2.1},
            {3.6, 4.7, 2.0},
            {3.5, 4.7, 2.0},
            {3.4, 4.7, 2.0},
            {3.3, 4.7, 2.0},
            {3.2, 4.7, 1.9},
            {3.1, 4.7, 1.9},
            {3.0, 4.7, 1.9},
            {2.9, 4.8, 1.8},
            {2.8, 4.8, 1.8},
            {2.7, 4.8, 1.8},
            {2.6, 4.8, 1.7},
            {2.5, 4.8, 1.7},
            {2.4, 4.8, 1.7},
            {2.3, 4.8, 1.7},
            {2.2, 4.8, 1.6},
            {2.1, 4.8, 1.6},
            {2.0, 4.8, 1.6},
            {1.9, 4.9, 1.5},
            {1.8, 4.9, 1.5},
            {1.7, 4.9, 1.5},
            {1.6, 4.9, 1.4},
            {1.5, 4.9, 1.4},
            {1.4, 4.9, 1.4},
            {1.3, 4.9, 1.4},
            {1.2, 4.9, 1.3},
            {1.1, 4.9, 1.3},
            {1.0, 4.9, 1.3},
            {0.9, 5.0, 1.2},
            {0.8, 5.0, 1.2},
            {0.7, 5.0, 1.2},
            {0.6, 5.0, 1.1},
            {0.5, 5.0, 1.1},
            {0.4, 5.0, 1.1},
            {0.3, 5.0, 1.1},
            {0.2, 5.0, 1.0},
            {0.1, 5.0, 1.0},
            {0.0, 5.0, 1.0},
    };

    public static double markConversion(Mark mark) {
        System.out.println("Simple Set the Object markConvLine, return the french Mark  ( for Mark Object constructor )");
        for (int i = 0 ; i < markTable.length ; i++) {
            if(mark.getMark() == markTable[i][MARK_FR]){
                for(int j =0; j<3; j++) {
                    System.out.println(markTable[i][j]);
                }
                mark.setMarkConvLine(i);
            }
        }
        return markTable[mark.getMarkConvLine()][MARK_FR];
    }

    public static double markConversion(Mark mark, double markValue, int markLanguage) {
        System.out.println("Mark conversion, Set the Object markConvLine, return the french Mark ( for Mark Object constructor ) ");
        for (int i = 0 ; i < markTable.length ; i++) {
            if(markValue == markTable[i][markLanguage]){
                mark.setMarkConvLine(i);
                mark.setMark(markTable[i][MARK_FR]);
                System.out.println(mark.getMark());
                break;
            }

        }
        return markTable[mark.getMarkConvLine()][MARK_FR];
    }

    public static double markConversion(Mark mark, double markValue, int inMarkLanguage, int outMarkLanguage) {
        System.out.println("Mark conversion, Set the Object markConvLine, return the out Language Mark");
        for (int i = 0 ; i < markTable.length ; i++) {
            if(markValue == markTable[i][inMarkLanguage]){
                mark.setMarkConvLine(i);
                mark.setMark(markTable[i][MARK_FR]);
                System.out.println(mark.getMark());
                break;
            }

        }
        return markTable[mark.getMarkConvLine()][outMarkLanguage];
    }

    public static double markConversion(Mark mark, int outMarkLanguage) {
        System.out.println("Mark conversion, Get the Object markConvLine, return the out Language Mark ");
        return markTable[mark.getMarkConvLine()][outMarkLanguage];
    }
*/
}



