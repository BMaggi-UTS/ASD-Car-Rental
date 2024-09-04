/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.12.v20180830
 * Generated at: 2024-09-03 06:07:33 UTC
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

public final class car_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"css/product.css\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        <title>Car Rental</title>\n");
      out.write("        ");

            //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector();
            //open a connection
            Connection con = conn.openConnection();
            //use the connection to create a productDAO controller
            CarDAO carDAO = new CarDAO(con);
            String carIdString = request.getParameter("id"); 
            Integer carID = Integer.parseInt(carIdString);
            Car car = carDAO.selectSpecificCar(carID);
        
      out.write("\n");
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
      out.write("                <div class=\"pic-content-wrapper\">\n");
      out.write("                    <div class=\"car-pic\">\n");
      out.write("                        <img src=\"");
      out.print( car.getCarImage() );
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"detail-content\">\n");
      out.write("                        <h1>");
      out.print( car.getCarModel() + " " + car.getCarTrim() );
      out.write("<h1>\n");
      out.write("                        <h2>");
      out.print( car.getCarMake() );
      out.write("</h2>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>icon</td>\n");
      out.write("                                <td>");
      out.print( car.getCarSeats() );
      out.write(" Seats</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>icon</td>\n");
      out.write("                                <td>");
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
      out.write(" </h2>\n");
      out.write("                                        ");
 } else if(car.getCarFuel().equals("H")) { 
      out.write("\n");
      out.write("                                            ");
      out.print( "Hybrid" );
      out.write(" </h2>\n");
      out.write("                                        ");
 } 
      out.write(" Drivetrain</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>icon</td>\n");
      out.write("                                <td>Fuel Efficient</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <h1 class=\"rental-price\"> $179<span>/ day</span></h1>\n");
      out.write("                        <a href=\"#\" class=\"select\"> Select </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div class=\"calendar-wrapper\">\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"month\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li>August<br><span style=\"font-size:18px\">2024</span></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <ul class=\"weekdays\">\n");
      out.write("                            <li>Mo</li>\n");
      out.write("                            <li>Tu</li>\n");
      out.write("                            <li>We</li>\n");
      out.write("                            <li>Th</li>\n");
      out.write("                            <li>Fr</li>\n");
      out.write("                            <li>Sa</li>\n");
      out.write("                            <li>Su</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"days\">\n");
      out.write("                            <li>1</li>\n");
      out.write("                            <li>2</li>\n");
      out.write("                            <li>3</li>\n");
      out.write("                            <li>4</li>\n");
      out.write("                            <li>5</li>\n");
      out.write("                            <li>6</li>\n");
      out.write("                            <li>7</li>\n");
      out.write("                            <li>8</li>\n");
      out.write("                            <li>9</li>\n");
      out.write("                            <li><span class=\"active\">10</span></li>\n");
      out.write("                            <li>11</li>\n");
      out.write("                            <li>12</li>\n");
      out.write("                            <li>13</li>\n");
      out.write("                            <li>14</li>\n");
      out.write("                            <li>15</li>\n");
      out.write("                            <li>16</li>\n");
      out.write("                            <li>17</li>\n");
      out.write("                            <li>18</li>\n");
      out.write("                            <li>19</li>\n");
      out.write("                            <li>20</li>\n");
      out.write("                            <li>21</li>\n");
      out.write("                            <li>22</li>\n");
      out.write("                            <li>23</li>\n");
      out.write("                            <li>24</li>\n");
      out.write("                            <li>25</li>\n");
      out.write("                            <li>26</li>\n");
      out.write("                            <li>27</li>\n");
      out.write("                            <li>28</li>\n");
      out.write("                            <li>29</li>\n");
      out.write("                            <li>30</li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"month\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li>September<br><span style=\"font-size:18px\">2024</span></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <ul class=\"weekdays\">\n");
      out.write("                            <li>Mo</li>\n");
      out.write("                            <li>Tu</li>\n");
      out.write("                            <li>We</li>\n");
      out.write("                            <li>Th</li>\n");
      out.write("                            <li>Fr</li>\n");
      out.write("                            <li>Sa</li>\n");
      out.write("                            <li>Su</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"days\">\n");
      out.write("                            <li>1</li>\n");
      out.write("                            <li>2</li>\n");
      out.write("                            <li>3</li>\n");
      out.write("                            <li>4</li>\n");
      out.write("                            <li>5</li>\n");
      out.write("                            <li>6</li>\n");
      out.write("                            <li>7</li>\n");
      out.write("                            <li>8</li>\n");
      out.write("                            <li>9</li>\n");
      out.write("                            <li>10</li>\n");
      out.write("                            <li>11</li>\n");
      out.write("                            <li>12</li>\n");
      out.write("                            <li>13</li>\n");
      out.write("                            <li>14</li>\n");
      out.write("                            <li>15</li>\n");
      out.write("                            <li>16</li>\n");
      out.write("                            <li>17</li>\n");
      out.write("                            <li>18</li>\n");
      out.write("                            <li>19</li>\n");
      out.write("                            <li>20</li>\n");
      out.write("                            <li>21</li>\n");
      out.write("                            <li>22</li>\n");
      out.write("                            <li>23</li>\n");
      out.write("                            <li>24</li>\n");
      out.write("                            <li>25</li>\n");
      out.write("                            <li>26</li>\n");
      out.write("                            <li>27</li>\n");
      out.write("                            <li>28</li>\n");
      out.write("                            <li>29</li>\n");
      out.write("                            <li>30</li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                            <li> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
