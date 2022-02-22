package rest.koios.client.backend.factory.options;

import lombok.Getter;

/**
 * Limit
 */
@Getter
public class Order extends Option {

    private final String param;
    private final SortType sortType;

    /**
     * Limit Option Constructor
     *
     * @param param Param to Order By
     * @param sortType SortType ASC or DESC
     */
    public Order(String param, SortType sortType) {
        super(OptionType.ORDER);
        this.param = param;
        this.sortType = sortType;
    }

    /**
     * Limit.of Static Constructor
     *
     * @param param    Parameter to Order By
     * @param sortType SortType - ASC or DESC
     * @return new Limit Option Object
     */
    public static Order by(String param, SortType sortType) {
        return new Order(param, sortType);
    }

    @Override
    public String getValue() {
        return param+"."+sortType.name().toLowerCase();
    }
}
