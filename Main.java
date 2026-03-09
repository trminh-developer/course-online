public class Main {
    public static void main(String[] args) {
        System.out.println("\nHỆ THỐNG QUẢN LÝ KHÓA HỌC TRỰC TUYẾN");

        // 1: Khởi tạo kho khóa học
        System.out.println("\n📚 KHỞI TẠO DANH SÁCH KHÓA HỌC...");

        OnlineCourse java101 = new OnlineCourse("Lập trình Java cơ bản", "Nguyễn Văn An", 1_200_000);
        OnlineCourse java202 = new OnlineCourse("Java Nâng cao - Design Patterns", "Trần Thị Bình", 2_500_000);
        OnlineCourse spring = new OnlineCourse("Spring Boot & REST API", "Lê Minh Cường", 3_000_000);
        OnlineCourse react = new OnlineCourse("ReactJS từ Zero to Hero", "Phạm Đức Dũng", 2_200_000);
        OnlineCourse sql = new OnlineCourse("SQL & Database Design", "Hoàng Thị Em", 1_500_000);
        OnlineCourse docker = new OnlineCourse("Docker & Kubernetes", "Vũ Thành Phong", 2_800_000);
        OnlineCourse python = new OnlineCourse("Python cho Data Science", "Đặng Thị Giang", 3_500_000);
        OnlineCourse cs = new OnlineCourse("Cyber Security", "TrMinh", 3_500_000);

        System.out.println("✓ Đã khởi tạo " + 7 + " khóa học");

        // 2: Tạo học viên
        System.out.println("\n👤 KHỞI TẠO HỌC VIÊN...");

        Learner hocVien1 = new Learner("Trần Đức Minh", "trminhlaptrinhvien@gmail.com");

        System.out.println("✓ " + hocVien1.getThongTin());

        // 1: Học viên đăng ký < 3 khóa (Không giảm giá)
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" 1: Đăng ký ÍT HƠN 3 khóa (Không giảm giá)");
        System.out.println("=".repeat(60));

        CourseOrder donHang1 = new CourseOrder(hocVien1);
        System.out.println("\nThêm khóa học vào đơn hàng của " + hocVien1.getName() + ":");
        donHang1.AddCourseOrder(java101);
        donHang1.AddCourseOrder(sql);
        donHang1.AddCourseOrder(python);
        donHang1.AddCourseOrder(docker);
        donHang1.AddCourseOrder(spring);
        donHang1.AddCourseOrder(react);
        donHang1.AddCourseOrder(java202);
        donHang1.AddCourseOrder(cs);

        donHang1.inDanhSachKhoaHoc();

        // 2: Học viên đăng ký >= 3 khóa (Được giảm 20%)
        // System.out.println("=".repeat(60));
        // System.out.println(" 2: Đăng ký ĐỦ 3 khóa trở lên (Giảm 20%)");
        // System.out.println("=".repeat(60));

        // CourseOrder donHang2 = new CourseOrder(hocVien1);
        // System.out.println("\nThêm khóa học vào đơn hàng của " + hocVien1.getName() +
        // ":");
        // donHang2.AddCourseOrder(java101);
        // donHang2.AddCourseOrder(spring);
        // donHang2.AddCourseOrder(react);
        // donHang2.AddCourseOrder(sql);

        // donHang2.inDanhSachKhoaHoc();

        // 3: Thêm khóa học trùng lặp
        // System.out.println("=".repeat(60));
        // System.out.println(" 3: Thử thêm khóa học TRÙNG LẶP");
        // System.out.println("=".repeat(60));

        // CourseOrder donHang3 = new CourseOrder(hocVien1);
        // System.out.println("\nThêm khóa học vào đơn hàng của " + hocVien1.getName() +
        // ":");
        // donHang3.AddCourseOrder(java202);
        // donHang3.AddCourseOrder(docker);
        // donHang3.AddCourseOrder(python);
        // donHang3.AddCourseOrder(java202); // Thêm trùng - sẽ báo cảnh báo
        // donHang3.AddCourseOrder(react);

        // donHang3.inDanhSachKhoaHoc();

        // 4: Kiểm tra validation input
        // System.out.println("=".repeat(60));
        // System.out.println(" 4: Kiểm tra VALIDATION dữ liệu đầu vào");
        // System.out.println("=".repeat(60));

        System.out.println("\nTest tên học viên rỗng:");
        try {
            new Learner("", "test@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✓ Exception bắt được: " + e.getMessage());
        }

        System.out.println("Test email không hợp lệ:");
        try {
            new Learner("Test User", "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✓ Exception bắt được: " + e.getMessage());
        }

        System.out.println("Test giá âm:");
        try {
            new OnlineCourse("Khóa Test", "GV Test", -100_000);
        } catch (IllegalArgumentException e) {
            System.out.println("  ✓ Exception bắt được: " + e.getMessage());
        }

        // BÁO CÁO TỔNG KẾT
        System.out.println("  TỔNG KẾT");
        System.out.printf("  %-30s %s%n", "Đơn hàng 1 (" + donHang1.getOrderId() + "):",
                String.format("%,d VND (không giảm giá)", (long) donHang1.ApDungGiamGia()));
    }
}
