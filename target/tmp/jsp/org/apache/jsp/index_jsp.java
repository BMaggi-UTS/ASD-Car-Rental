/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.12.v20180830
 * Generated at: 2024-09-05 06:44:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.*;
import model.*;
import java.sql.*;
import model.dao.CarDAO;
import model.dao.DBConnector;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/assets/footer.jsp", Long.valueOf(1724152331486L));
    _jspx_dependants.put("/assets/nav.jsp", Long.valueOf(1725326538212L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("controller");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.dao.CarDAO");
    _jspx_imports_classes.add("model.dao.DBConnector");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("        <script src=\"https://kit.fontawesome.com/cd2f5b5ad0.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Car Rental</title>\n");
      out.write("        ");
 //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector(); 
      out.write("\n");
      out.write("            ");
 //open a connection
            Connection con = conn.openConnection(); 
      out.write("\n");
      out.write("            ");
 //use the connection to create a productDAO controller
            CarDAO carDAO = new CarDAO(con); 
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"web-wrapper\">\n");
      out.write("            ");
      out.write("<nav>\n");
      out.write("  <div class=\"container navbar\">\n");
      out.write("    <a href=\"/index.jsp\"><img src=\"/assets/logo.png\" alt=\"logo\" class=\"logo\"/></a>\n");
      out.write("    <div class=\"search-div\">\n");
      out.write("      <input type=\"text\" placeholder=\"Search for your next rental . . .\" />\n");
      out.write("      <i class=\"fa-solid fa-magnifying-glass search-icon fa-2xl\"></i>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"cart-div\">\n");
      out.write("      <i class=\"fa-solid fa-car fa-2xl\"></i>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("            <main class=\"main-container\">\n");
      out.write("                <div class=\"location-availability-wrapper\">\n");
      out.write("                    <h1>Sydney Car Rental</h1>\n");
      out.write("                    <div class=\"location-selector\">\n");
      out.write("                        <div class=\"location-selector-wrapper\">\n");
      out.write("                            <div class=\"selector-wrapper\">\n");
      out.write("                                <p class=\"label\">Pickup</p>\n");
      out.write("                                <div class=\"pickup pickme\">\n");
      out.write("                                    <input Type=\"text\" placeholder=\"Search...\" id=\"pickup\" onkeyup=\"filterFunction()\" class=\"selector\" autocomplete=\"off\">\n");
      out.write("                                    <div id=\"search-results\" class=\"pickme\">\n");
      out.write("                                        <button onclick=\"clickResultPickup('Sydney')\">Sydney</button>\n");
      out.write("                                        <button onclick=\"clickResultPickup('Brisbane')\">Brisbane</button>\n");
      out.write("                                        <button onclick=\"clickResultPickup('Adelaide')\">Adelaide</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"selector-wrapper\">\n");
      out.write("                                <p class=\"label\">Dropoff</p>\n");
      out.write("                                <div class=\"dropoff pickme\">   \n");
      out.write("                                    <input Type=\"text\" placeholder=\"Search...\" id=\"dropoff\" onkeyup=\"filterFunction2()\" class=\"selector\" autocomplete=\"off\">\n");
      out.write("                                    <div id=\"search-results2\" class=\"pickme\">\n");
      out.write("                                        <button onclick=\"clickResultPickup2('Sydney')\">Sydney</button>\n");
      out.write("                                        <button onclick=\"clickResultPickup2('Brisbane')\">Brisbane</button>\n");
      out.write("                                        <button onclick=\"clickResultPickup2('Adelaide')\">Adelaide</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"price-selector-wrapper selector-wrapper\" id=\"priceorkm\">\n");
      out.write("                            <button onclick=\"darken('day')\" id=\"day\" class=\"not-selected\">Pay by day</button>\n");
      out.write("                            <button onclick=\"darken('km')\" id=\"km\" class=\"not-selected\">Pay by KM</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"km-wrapper\" id=\"km-holder\">\n");
      out.write("                            <p>Estimated travel kms</p>\n");
      out.write("                            <input type=\"text\" placeholder=\"1234\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"availability-selector\">\n");
      out.write("                        <div class=\"date-wrapper\">\n");
      out.write("                            <input type=\"date\">\n");
      out.write("                            <input type=\"date\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"price-selector-wrapper selector-wrapper\" id=\"age\">\n");
      out.write("                            <button onclick=\"darken('day')\" id=\"day\" class=\"not-selected\">21-25</button>\n");
      out.write("                            <button onclick=\"darken('km')\" id=\"km\" class=\"not-selected\">25+</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"submit-search\">\n");
      out.write("                            <input type=\"submit\" value=\"Search\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"filter-bar-wrapper\">\n");
      out.write("                    <div class=\"filter-bar-search-wrapper\">\n");
      out.write("                        <input type=\"text\" class=\"filter-bar-search\" placeholder=\"Search...\">\n");
      out.write("                        <i class=\"fa-solid fa-magnifying-glass filter-bar-search-wrapper-i\"></i>\n");
      out.write("                        </input>\n");
      out.write("                    </div>\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <div class=\"filter-bar-wrapper-div\">\n");
      out.write("                        <i class=\"fa-solid fa-sort\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"filter-bar-wrapper-div filter-icon-border\">\n");
      out.write("                        <i class=\"fa-solid fa-filter\"></i>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"product-wrapper\">\n");
      out.write("                ");
 ArrayList<Car> cars = carDAO.fetchCars(); 
      out.write("\n");
      out.write("                ");
 for(Car car : cars) { 
      out.write("\n");
      out.write("                <a href=\"/car.jsp?id=");
      out.print( car.getCarID() );
      out.write("\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"imgBox\">\n");
      out.write("                            <img src=\"");
      out.print( car.getCarImage() );
      out.write("\" alt=\"");
      out.print( car.getCarMake() );
      out.write("\" class=\"car\">\n");
      out.write("                            <div class=\"make-model\">\n");
      out.write("                                <h3>");
      out.print( car.getCarMake() );
      out.write("</h3>\n");
      out.write("                                <h3>");
      out.print( car.getCarModel() );
      out.write("</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                        <div class=\"contentBox\">\n");
      out.write("                            <div class=\"card-content\">\n");
      out.write("                                <div class=\"car-details\">\n");
      out.write("                                    <div>\n");
      out.write("                                        <i class=\"fa-solid fa-chair\"></i>\n");
      out.write("                                        <h2> ");
      out.print( car.getCarSeats() );
      out.write(" Seats </h2>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div>\n");
      out.write("                                        <i class=\"fa-solid fa-gas-pump\"></i>\n");
      out.write("                                        <h2> \n");
      out.write("                                        ");
 if(car.getCarFuel().equals("P")) { 
      out.write("\n");
      out.write("                                            ");
      out.print( "Petrol" );
      out.write("\n");
      out.write("                                        ");
 } else if(car.getCarFuel().equals("D")) { 
      out.write("\n");
      out.write("                                            ");
      out.print( "Diesel" );
      out.write("\n");
      out.write("                                        ");
 } else if(car.getCarFuel().equals("H")) { 
      out.write("\n");
      out.write("                                            ");
      out.print( "Hybrid" );
      out.write("\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                        </h2>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div>\n");
      out.write("                                        <i class=\"fa-solid fa-car-side\"></i>\n");
      out.write("                                        <h2> ");
      out.print( car.getCarBodyStyle() );
      out.write("</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"detail-price\">\n");
      out.write("                                    <h2>$");
      out.print( car.getCarPriceKM() );
      out.write(" <span>/ a KM</span></h2>\n");
      out.write("                                    <h2>");
      out.print( car.getCarQuip() );
      out.write("</h2>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"#\" class=\"buy\">Book Now</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                </div>    \n");
      out.write("            </main>\n");
      out.write("            ");
      out.write("<footer>\n");
      out.write("    <div class=\"footer-container\">\n");
      out.write("        <div class=\"footer-left\">\n");
      out.write("            <div>\n");
      out.write("                <a href=\"/index.jsp\">\n");
      out.write("                ");
      out.write("\n");
      out.write("            </a>\n");
      out.write("            <p>All Your Car Needs In One Place</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"AOC-div\">\n");
      out.write("            <h1>Acknowledgement of Country</h1>\n");
      out.write("            <p>\n");
      out.write("                We acknowledges Aboriginal and Torres Strait Islander people\n");
      out.write("                as the Traditional Custodians of the land and acknowledges and\n");
      out.write("                pays respect to their Elders, past and present.\n");
      out.write("            </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-right\">\n");
      out.write("            <div class=\"footer-links\">\n");
      out.write("            <div>\n");
      out.write("                <p>Showcase</p>\n");
      out.write("                <p>Services</p>\n");
      out.write("                <p>Privacy policy</p>\n");
      out.write("                <p>Return policy</p>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <p>About Us</p>\n");
      out.write("                <p>Contact Us</p>\n");
      out.write("                <p>Affiliates</p>\n");
      out.write("                <p>Resources</p>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container footer-footer\">\n");
      out.write("        <p>Copyright &copy 2024. All rights reserved.</p>\n");
      out.write("        <p>Built by ASD Group</p>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<script src=\"js/script.js\"></script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
