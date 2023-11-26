class MySecondClass{
    private int num1;
    private int num2;
    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public void setNum1(int num1){
        this.num1=num1;
    }
    public void setNum2(int num2){
            this.num2=num2;
    }
    public MySecondClass(int num1, int num2){
        this.num1=num1;
        this.num2=num2;
    }
    public int stepLeft(){
        return num1 << num2;
    }
}

class MyFirstClass {
    public static void main(String[] s) {
        MySecondClass o=new MySecondClass(0,0);
        System.out.println(o.stepLeft());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setNum1(i);
                o.setNum2(j);
                System.out.print(o.stepLeft());
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}