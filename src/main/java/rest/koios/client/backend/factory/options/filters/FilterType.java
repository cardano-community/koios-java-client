package rest.koios.client.backend.factory.options.filters;

/**
 * Filter Type
 */
public enum FilterType {

    /**
     * equals
     */
    EQ,

    /**
     * greater than
     */
    GT,

    /**
     * greater than or equal
     */
    GTE,

    /**
     * less than
     */
    LT,

    /**
     * less than or equal
     */
    LTE,

    /**
     * not equal
     */
    NEQ,

    /**
     * LIKE operator (use * in place of %)
     */
    LIKE, // TODO Not Supported

    /**
     * one of a list of values, e.g. ?a=in.("hi,there","yes,you")
     */
    IN, // TODO Not Supported

    /**
     * checking for exact equality (null,true,false,unknown)
     */
    IS, // TODO Not Supported

    /**
     * contains e.g. ?tags=cs.{example, new}
     */
    CS, // TODO Not Supported

    /**
     * contained in e.g. ?values=cd.{1,2,3}
     */
    CD // TODO Not Supported
}