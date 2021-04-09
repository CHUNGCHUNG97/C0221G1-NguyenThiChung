package AbstractClass.Thuc_hanh.trienKhaiInterface;

import KeThua.Thuc_hanh.doi_tuong_hinh_hoc.Circle;

import java.util.Comparator;

class CircleComparato implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) return 1;
        else if (o1.getRadius() < o2.getRadius()) return -1;
        else return 0;
    }
}
