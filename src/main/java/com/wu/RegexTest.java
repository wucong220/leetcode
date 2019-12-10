package com.wu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuc006
 * @date 2019/8/27 10:01
 */
public class RegexTest {
    public void test(){
        System.out.println((int)Float.parseFloat("6666.66"));
        String s1 ="          <c:dLbl>\n" +
                "            <c:idx val=\"6\"/>\n" +
                "            <c:layout>\n" +
                "              <c:manualLayout>\n" +
                "                <c:x val=\"-0.00119664938173115\"/>\n" +
                "                <c:y val=\"-0.611010902105411\"/>\n" +
                "              </c:manualLayout>\n" +
                "            </c:layout>\n" +
                "            <c:tx>\n" +
                "              <c:rich>\n" +
                "                <a:bodyPr vertOverflow=\"ellipsis\" anchor=\"ctr\" anchorCtr=\"1\"/>\n" +
                "                <a:lstStyle/>\n" +
                "                <a:p>\n" +
                "                  <a:r>\n" +
                "                    <a:rPr lang=\"en-US\" altLang=\"en-US\" sz=\"1600\" b=\"1\"/>\n" +
                "                    <a:t></a:t>\n" +
                "                  </a:r>\n" +
                "                  <a:r>\n" +
                "                    <a:rPr lang=\"en-US\" altLang=\"en-US\" sz=\"1600\" b=\"1\" smtClean=\"0\"/>\n" +
                "                    <a:t>6,099</a:t>\n" +
                "                  </a:r>\n" +
                "                  <a:endParaRPr lang=\"en-US\" altLang=\"en-US\"/>\n" +
                "                </a:p>\n" +
                "              </c:rich>\n" +
                "            </c:tx>\n" +
                "            <c:numFmt formatCode=\"General\" sourceLinked=\"1\"/>\n" +
                "            <c:dLblPos val=\"ctr\"/>\n" +
                "            <c:showLegendKey val=\"0\"/>\n" +
                "            <c:showVal val=\"1\"/>\n" +
                "            <c:showCatName val=\"0\"/>\n" +
                "            <c:showSerName val=\"0\"/>\n" +
                "            <c:showPercent val=\"0\"/>\n" +
                "            <c:showBubbleSize val=\"0\"/>\n" +
                "            <c:extLst>\n" +
                "              <c:ext uri=\"{CE6537A1-D6FC-4f65-9D91-7224C49458BB}\" xmlns:c15=\"http://schemas.microsoft.com/office/drawing/2012/chart\">\n" +
                "                <c15:layout/>\n" +
                "              </c:ext>\n" +
                "            </c:extLst>\n" +
                "          </c:dLbl>";
//        String s2=s1.replaceAll("(<c:dLbl>[\\s\\S]*?)<c:tx>[\\s\\S]*?<\\/c:tx>([\\s\\S]*?</c:dLbl>)","\\1\\2");
        Pattern p = Pattern.compile("(<c:dLbl>[\\s\\S]*?)<c:tx>[\\s\\S]*?</c:tx>([\\s\\S]*?</c:dLbl>)");
        Matcher matcher = p.matcher(s1);
        matcher.find();
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(1)+matcher.group(2));
    }
}
