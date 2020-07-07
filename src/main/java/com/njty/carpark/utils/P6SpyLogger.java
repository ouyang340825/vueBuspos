package com.njty.carpark.utils;


import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.util.regex.Matcher;

/**
 * p6spy打印日志输出格式修改
 * Created by ouyangshuai on 2019/11/11.
 */
public class P6SpyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now,long elapsed, String category, String prepared, String sql, String s4) {
        if (!sql.trim().equals("")) {
            return  "SQL耗时=====================> " + elapsed + "ms" + "\n" + Matcher.quoteReplacement(P6Util.singleLine(sql)) + ";";
        }
        return "";
    }


}
