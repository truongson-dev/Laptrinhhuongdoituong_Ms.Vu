package BuildClass;

import java.util.Comparator;

public class SortByDiem implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		// Sắp xếp tăng dần theo điểm trung bình
		return Double.compare(s1.getDiemTB(), s2.getDiemTB());

		// Nếu muốn sắp xếp giảm dần, sử dụng:
		// return Double.compare(s2.getDiemTB(), s1.getDiemTB());
	}
}