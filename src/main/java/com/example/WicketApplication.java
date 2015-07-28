package com.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.apache.wicket.util.crypt.CharEncoding;

import de.agilecoders.wicket.webjars.WicketWebjars;
import de.agilecoders.wicket.webjars.settings.WebjarsSettings;

/**
 * Application object for your web application. If you want to run this application without
 * deploying, run the Start class.
 * 
 * @see com.example.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends WebPage> getHomePage() {
    return HomePage.class;
  }

  /**
   * @see org.apache.wicket.Application#init()
   */
  @Override
  public void init() {
    super.init();
    // サーバ・クライアント間のリクエスト・レスポンス時の文字エンコード
    getRequestCycleSettings().setResponseRequestEncoding(CharEncoding.UTF_8);
    // Wicketに取り込まれるHTMLファイルのエンコード
    getMarkupSettings().setDefaultMarkupEncoding(CharEncoding.UTF_8);
    // ブラウザにあわせたJQueryの読み込み
    getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());
    // WebJarsの読み込み
    WebjarsSettings settings = new WebjarsSettings();
    WicketWebjars.install(this, settings);
    // ページマウント
    mountPage("Home", HomePage.class);
  }
}
