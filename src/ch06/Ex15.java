package ch06;

public class Ex15 {
    String name;
    String id;
    String password;
    int age;

    public Ex15(String name, String id){
        this.name = name;
        this.id = id;
    }
    public boolean login (String id, String password){
        boolean result;
        if (id.equals("hong") && password.equals("12345")){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    public void logout(){
        System.out.println(id + "님이 로그아웃 되었습니다.");
    }
}