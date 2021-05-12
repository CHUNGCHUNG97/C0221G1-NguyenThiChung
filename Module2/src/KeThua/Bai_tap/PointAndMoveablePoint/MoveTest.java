package KeThua.Bai_tap.PointAndMoveablePoint;

public class MoveTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(3, 2, 1, 6);

//        moveablePoint.setXY(2, 2);
//        moveablePoint.setSpeed(5, 4);
        System.out.println(moveablePoint.toString());
        moveablePoint.move();
        System.out.println(moveablePoint.toString());
    }
}
