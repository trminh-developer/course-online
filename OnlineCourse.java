public class OnlineCourse {
    private String TenKhoaHoc;
    private String GiangVien;
    private double Gia;
    // Biến đếm tự động ID
    private static int idCounter = 1000;
    private final int id;

    /**
     * Constructor khởi tạo khóa học
     * 
     * @param tenKhoaHoc tên khóa học
     * @param giangVien  tên giảng viên
     * @param gia        giá khóa học (VND)
     */

    public OnlineCourse(String TenKhoaHoc, String GiangVien, double Gia) {
        if (TenKhoaHoc == null || TenKhoaHoc.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên khóa học không được để trống");
        }
        if (GiangVien == null || GiangVien.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên giảng viên không được để trống");
        }
        if (Gia < 0) {
            throw new IllegalArgumentException("Giá khóa học không được để âm");
        }
        this.id = ++idCounter;
        this.TenKhoaHoc = TenKhoaHoc.trim();
        this.GiangVien = GiangVien.trim();
        this.Gia = Gia;
    }

    public String getThongTin() {
        return String.format("[ID:%d] %-35s | GV: %-20s | Giá: %,.0f VND",
                id, TenKhoaHoc, GiangVien, Gia);
    }

    /**
     * Lấy giá khóa học
     * 
     * @return giá (double)
     */
    public double getGia() {
        return Gia;
    }

    public int getId() {
        return id;
    }

    public String getTenKhoaHoc() {
        return TenKhoaHoc;
    }

    public String getGiangVien() {
        return GiangVien;
    }

    public void setGia(double Gia) {
        if (Gia < 0)
            throw new IllegalArgumentException("Giá không được âm!");
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return getThongTin();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof OnlineCourse))
            return false;
        OnlineCourse other = (OnlineCourse) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
