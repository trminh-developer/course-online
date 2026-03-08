public class Learner {
    private String name;
    private String email;

    /**
     * Constructor khởi tạo học viên
     * 
     * @param name  tên học viên
     * @param email địa chỉ email
     */
    public Learner(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên học viên không được để trống");
        }
        if (email == null || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Email không hợp lệ!");
        }
        this.name = name.trim();
        this.email = email.trim().toLowerCase();
    }

    /**
     * Lấy thông tin đầy đủ của học viên
     * 
     * @return chuỗi thông tin học viên
     */

    public String getThongTin() {
        return String.format("Học viên: %-20s | Email: %s", name, email);
    }

    /**
     * Lấy địa chỉ email
     * 
     * @return email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Lấy tên học viên
     * 
     * @return tên học viên
     */

    public String getName() {
        return name;
    }

    /**
     * Cập nhật tên học viên
     * 
     * @param name tên mới
     */

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên học viên không được để trống");
        }
        this.name = name.trim();
    }

    /**
     * Cập nhật email
     * 
     * @param email email mới
     */

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }
        this.email = email.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return getThongTin();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Learner))
            return false;
        Learner other = (Learner) obj;
        return this.email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}