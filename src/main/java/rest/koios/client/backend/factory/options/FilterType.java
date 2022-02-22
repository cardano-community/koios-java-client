package rest.koios.client.backend.factory.options;

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
    LIKE,

    /**
     * one of a list of values, e.g. ?a=in.("hi,there","yes,you")
     */
    IN,

    /**
     * checking for exact equality (null,true,false,unknown)
     */
    IS,

    /**
     * contains e.g. ?tags=cs.{example, new}
     */
    CS,

    /**
     * contained in e.g. ?values=cd.{1,2,3}
     */
    CD,

    /**
     * negates another operator
     */
    NOT,

    /**
     * logical OR operator
     */
    OR,

    /**
     * logical AND operator
     */
    AND
}