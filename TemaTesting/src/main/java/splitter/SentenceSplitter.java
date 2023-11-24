package splitter;

public class SentenceSplitter {
    public String[] split(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            System.out.println("Write an expresion");
            return new String[0];

        }
        sentence=sentence.toLowerCase();
        int arrLength=0;
        for (int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)==' '){
                arrLength++;

            }
        }
        String[]myArr=new String[arrLength+1];
        int indexNumber=0;
        String word="";
        for (int i=0;i<sentence.length();i++){
            char character=sentence.charAt(i);
            if(character!=' ') {
                word = word + character;
            }
            else{
                myArr[indexNumber]=word;
                indexNumber++;
                word="";
                }
            if(i==sentence.length()-1){
                myArr[indexNumber]=word;
            }
            }
        return myArr;
        }
    }

