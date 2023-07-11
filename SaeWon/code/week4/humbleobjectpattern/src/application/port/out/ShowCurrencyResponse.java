package application.port.out;

public record ShowCurrencyResponse (String amount){
    @Override
    public String toString() {
        return "ShowCurrencyResponse{" +
                "amount='" + amount + '\'' +
                '}';
    }
}
