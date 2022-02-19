package rest.koios.client.utils;

/**
 * Tuple Of 2 Types
 *
 * @param <T> Type T Param 1
 * @param <Z> Type Z Param 2
 */
public class Tuple<T, Z> {

    /**
     * First Parameter
     */
    public T _1;

    /**
     * Second Parameter
     */
    public Z _2;

    /**
     * Tuple Constructor
     *
     * @param _1 First Parameter
     * @param _2 Second Parameter
     */
    public Tuple(T _1, Z _2) {
        this._1 = _1;
        this._2 = _2;
    }
}
