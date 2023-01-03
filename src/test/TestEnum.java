package test;

import java.util.stream.Stream;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-10-20
 */
public enum TestEnum {
    aaaabbbb("delaySLI"), //延时流的直播id
    ;

    private final String prefix;

    TestEnum(String prefix) {
        this.prefix = prefix;
    }

    public String of(Object... suffix) {
        StringBuilder sb = new StringBuilder(this.prefix);
        if (suffix.length > 0) {
            Stream.of(suffix).forEach(suf -> sb.append("_").append(suf));
        }
        return sb.toString();
    }
}
