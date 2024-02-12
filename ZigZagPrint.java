package org.example;
/*
    2. Print the given string in Zig-Zag
    Example:
    input = “zohocorporation" //15 --> length // ( 15 / 2) //((str.length() / noOfRows) + 2)
    numOfRows = 3;
    Form the string in Zig-Zag

    z        c        o        i
    o   o    o   p    r    t   o
    h        r        a        n   // 15 --> 7

    Output:
    zcoioooprtohran

 */
public class ZigZagPrint {
    int noOfRows;
    String str;
    char[][] charArr;
    ZigZagPrint(){
        this.str = "zohocorporation";
        this.noOfRows = 3;
        this.charArr = new char[noOfRows][ (str.length()/noOfRows)+2 ];
    }
    ZigZagPrint(String str , int noOfRows){
        this.str  = str;
        this.noOfRows = noOfRows;
        this.charArr = new char[noOfRows][ (str.length()/noOfRows)+(((str.length()%2))+2) ];
    }
    void zigZagPrint(){
        int count = 0;
        for(int i = 0 ; i < charArr[0].length ; i++){
            for(int j = 0 ; j < charArr.length ; j++){
                if((i%2!=1 || j%2==1) ){
                    if(count < str.length()) {
                        charArr[j][i] = str.charAt(count);
                        count++;
                    }
                }
                else {
                    charArr[j][i] = ' ';
                }
                if(charArr[j][i]=='\0'){
                    charArr[j][i]=' ';
                }
            }
        }
    }
    void printCharArr(char[][] charArr){
        for(int i = 0 ; i < charArr.length ; i++){
            for(int j = 0 ; j < charArr[i].length ; j++){
                System.out.print(charArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    String output(char[][] charArr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < charArr.length ; i++){
            for(int j = 0 ; j < charArr[i].length ; j++){
                if(charArr[i][j]!=' ')sb.append(charArr[i][j]);
            }
        }
        return sb.toString();

    }




    public static void main(String[] args) {
        ZigZagPrint obj = new ZigZagPrint();
        obj.zigZagPrint();
        obj.printCharArr(obj.charArr);
        System.out.println("output--> "+obj.output(obj.charArr));
        System.out.println();

        ZigZagPrint obj2 = new ZigZagPrint("hellowelcometohouse",4);
        obj2.zigZagPrint();
        obj2.printCharArr(obj2.charArr);
        System.out.println("output--> "+obj2.output(obj2.charArr));


    }

}
