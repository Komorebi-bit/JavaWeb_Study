package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Komorebi
 * @date 2022.05.23.21:02
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    //敏感词汇集合
    private List<String> list = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try{
            //获取真实文件路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //读取文件 本地的流默认创建出来的时是gbk的
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //其他编码文件，用此方法读取
            // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath),"UTF-8"));
            //将文件的每一行数据读入list集合中
            String line = null;
            while((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if (method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value =(String) method.invoke(servletRequest, args);
                    if(value!=null){
                        for(String str:list){
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
        });
        //放行
        filterChain.doFilter(proxy_req,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
