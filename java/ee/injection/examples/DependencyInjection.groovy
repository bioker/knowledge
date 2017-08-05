import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.servlet.http.HttpServlet

@RequestScoped
class CurrencyConverter {

    //...

}

class MyServlet extends HttpServlet {
    
    @Inject
    private CurrencyConverter currencyConverter

}
