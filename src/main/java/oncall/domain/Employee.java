package oncall.domain;

public record Employee(
    String name
) {
    public static Employee fromString(String data){
        if (!data.matches("^[가-힣]+$")) {
            throw new IllegalArgumentException("닉네임만 한글만 가능합니다.");
        }

        if (data.length() > 5) {
            throw new IllegalArgumentException("닉네임은 최대 5자까지 가능합니다.");
        }

        return new Employee(data);
    }
}
