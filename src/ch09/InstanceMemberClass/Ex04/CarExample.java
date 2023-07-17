package ch09.InstanceMemberClass.Ex04;

public class CarExample {
    public static void main(String[] args) {
        Car mycar = new Car();
        Car.Tire tire = mycar.new Tire();
        Car.Engine engine = new Car.Engine();
    }
}
