import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseOrder implements DiscountRule {
    private Learner hocVien;
    private ArrayList<OnlineCourse> list_course;
    private static int orderCounter = 1;
    private final String orderId;

    /**
     * Constructor tạo đơn hàng mới cho học viên
     * 
     * @param hocVien học viên đặt hàng
     */

    public CourseOrder(Learner hocVien) {
        if (hocVien == null) {
            throw new IllegalArgumentException("Học viên khoonng được bỏ trống!");
        }
        this.hocVien = hocVien;
        this.list_course = new ArrayList<>();
        this.orderId = String.format("0RD-%04d ", orderCounter++);
    }

    /**
     * Thêm khóa học vào đơn hàng
     * 
     * @param khoaHoc khóa học cần thêm
     */

    public void AddCourseOrder(OnlineCourse khoaHoc) {
        if (khoaHoc == null) {
            throw new IllegalArgumentException("Khóa học không được trống!");
        }
        if (list_course.contains(khoaHoc)) {
            System.out.println("Khóa học: " + khoaHoc.getTenKhoaHoc() + "Đã có đơn hàng");
            return;
        }
        list_course.add(khoaHoc);
        System.out.println("✓ Đã thêm: " + khoaHoc.getTenKhoaHoc());
    }

    /**
     * Tính tổng tiền gốc (chưa giảm)
     * return tổng tiền (double)
     */

    public double TinhTongTien() {
        return list_course.stream()
                .mapToDouble(OnlineCourse::getGia)
                .sum();
    }

    /**
     * Áp dụng giảm giá và trả về số tiền phải trả
     * Nếu đủ điều kiện (>= MIN_COURSES), giảm DISCOUNT_RATE%
     * 
     * @return số tiền sau giảm giá
     */

    public double ApDungGiamGia() {
        double tongtien = TinhTongTien();
        if (ApDung(list_course.size())) {
            return tongtien * (1 - DISCOUNT_RATE);
        }
        return tongtien;
    }

    /**
     * In danh sách khóa học và thông tin đơn hàng ra màn hình
     */

    public void inDanhSachKhoaHoc() {
        String line = "=".repeat(75);
        String thinLine = "-".repeat(75);
        System.out.println("\n" + line);
        System.out.println("Đơn hàng: " + orderId);
        System.out.println(thinLine);
        System.out.println(" " + hocVien.getThongTin());
        System.out.println(thinLine);

        if (list_course.isEmpty()) {
            System.out.println("Chưa có khóa học nào trong đơn hàng");
        } else {
            System.out.printf("%-3s %-35s %-18s  %12s%n", "STT", "Tên khóa học", "Giảng viên", "Giá (VNĐ)");
            System.out.println(" " + thinLine.substring(2));

            for (int i = 0; i < list_course.size(); i++) {
                OnlineCourse kh = list_course.get(i);
                System.out.printf("%-3d  %-35s  %-18s  %,12.0f%n", (i - 1), kh.getTenKhoaHoc(), kh.getGiangVien(),
                        kh.getGia());
            }
            System.out.println(" " + thinLine.substring(2));
            System.out.printf(" %-59s  %,12.0f%n", "TỔNG TIỀN GỐC: ", TinhTongTien());

            if (ApDung(list_course.size())) {
                double soTienGiam = TinhTongTien() * DISCOUNT_RATE;
                System.out.printf("  %-59s  %,12.0f%n", String.format("GIẢM GIÁ (%.0f%% - đã đăng ký %d khóa):",
                        DISCOUNT_RATE * 100, list_course.size()), -soTienGiam);
                System.out.println(" " + thinLine.substring(2));
                System.out.printf(" %-59s %,12.0f%n", "THÀNH TIỀN: ", ApDungGiamGia());
            } else {
                int conLai = Min_Course - list_course.size();
                System.out.printf("%-59s %,12.0f%n", "THÀNH TIỀN: ", ApDungGiamGia());
                System.out.printf("[Đăng ký thêm %d khóa nửa để được giảm %.0f%%]%n", conLai, DISCOUNT_RATE * 100);
            }
        }
        System.out.println(line + "\n");
    }

    /**
     * Kiểm tra điều kiện giảm giá
     * 
     * @param soLuong số lượng khóa học
     * @return true nếu soLuong >= MIN_COURSES
     */

    @Override
    public boolean ApDung(int soLuong) {
        return soLuong >= Min_Course;
    }

    public Learner getHocVien() {
        return hocVien;
    }

    public List<OnlineCourse> getDanhSachKhoaHoc() {
        return Collections.unmodifiableList(list_course);
    }

    public String getOrderId() {
        return orderId;
    }

    public int getSoLuongKhoaHoc() {
        return list_course.size();
    }

    @Override
    public String toString() {
        return String.format("CourseOrder{id='%s', hocVien='%s', soKhoaHoc=%d, tongTien=%,.0f}",
                orderId, hocVien.getName(), list_course.size(), ApDungGiamGia());
    }
}
