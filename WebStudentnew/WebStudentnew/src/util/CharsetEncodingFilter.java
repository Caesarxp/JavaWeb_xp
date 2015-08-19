 
  package util;

  import java.io.IOException;
  import javax.servlet.Filter;
  import javax.servlet.FilterChain;
  import javax.servlet.FilterConfig;
  import javax.servlet.ServletException;
  import javax.servlet.ServletRequest;
  import javax.servlet.ServletResponse;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  /**
   * 
   * @author Administrator
   *  编码过滤器
   */
  public class CharsetEncodingFilter implements Filter {

   private String encoding;
	
	public void destroy() {
		System.out.println("CharsetEncodingFilter.destroy()");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		//System.out.println("CharsetEncodingFilter.doFilter()");
		//设置字符集
		request.setCharacterEncoding(encoding);
		//System.out.println("--------doFilter begin----------");
		//如果继续执行其他的操作，必须显示的执行如下语句
		chain.doFilter(request, response);
		//System.out.println("--------doFilter end----------");
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		System.out.println("encoding=" + encoding);
	}

  }
