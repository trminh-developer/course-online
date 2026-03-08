public interface DiscountRule {
    int Min_Course = 3;

    double DISCOUNT_RATE = 0.20;

    /**
     * Kiểm tra xem có được áp dụng giảm giá không
     * 
     * @param soLuong số lượng khóa học đăng ký
     * @return true nếu đủ điều kiện giảm giá
     */
    boolean ApDung(int soLuong);

}
