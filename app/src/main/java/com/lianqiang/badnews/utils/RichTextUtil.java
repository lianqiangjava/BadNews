package com.lianqiang.badnews.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.lianqiang.badnews.R;
import com.lianqiang.badnews.module.news.bean.NewsDetail;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Describe: 处理html字符串中的图片
 *
 * @author lianqiang on 2017/5/22.
 */

public class RichTextUtil {

    public static void formatHtml(final Context context, TextView tv, NewsDetail bean){

        String detail = bean.getBody();

        if(bean.getImg() !=null && bean.getImg().size()>0){
            Pattern pattern = Pattern.compile("<!--IMG#\\d-->");
            Matcher matcher = pattern.matcher(detail);

            StringBuffer sb = new StringBuffer();
            while (matcher.find()){
                String findStr = matcher.group();
                String imgUrl = "";

                for (NewsDetail.ImgBean imgBean : bean.getImg()) {
                    if(findStr.equals(imgBean.getRef())){
                        imgUrl = imgBean.getSrc();
                        break;
                    }
                }

                if(!TextUtils.isEmpty(imgUrl)){
                    matcher.appendReplacement(sb,getImgTag(imgUrl));
                }
            }
            matcher.appendTail(sb);

            detail = sb.toString();
        }

        RichText.fromHtml(detail)
                .clickable(true)
                .placeHolder(R.drawable.default_img)
                .error(R.drawable.default_img)
                .imageClick(new OnImageClickListener() {
                    @Override
                    public void imageClicked(List<String> imageUrls, int position) {
                        Log.e("afwefw", "点击图片: " +imageUrls.get(position) );
                    }
                })
                .into(tv);
    }


    private static String getImgTag(String url){

        StringBuffer sb = new StringBuffer();
        sb.append("<img src=\"");
        sb.append(url);
        sb.append("\" />");

        return sb.toString();
    }


}
