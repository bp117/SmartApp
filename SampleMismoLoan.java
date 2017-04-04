import org.apache.axis.utils.XMLUtils;
import org.commerce.mismo.LoanApplication;
import org.commerce.mismo.bean.BorrowerBean;
import org.commerce.mismo.bean.LoanApplicationBean;
import org.commerce.mismo.xml.MismoXmlGenerator;
import org.w3c.dom.Document;

public class SampleMismoLoan {

   private static LoanApplication getLoanApplication() {
      LoanApplicationBean loanApplication = new LoanApplicationBean();
      BorrowerBean borrowerBean = new BorrowerBean();
      borrowerBean.setFirstName("John");
      borrowerBean.setLastName("Smith");
      loanApplication.addBorrower(borrowerBean);
      return loanApplication;
   }

   public static void main(String[] args) throws Exception {
      MismoXmlGenerator mismoXmlGenerator = new MismoXmlGenerator();
      LoanApplication mismoApp = getLoanApplication();
      Document mismoXml = mismoXmlGenerator.getMismoXml(mismoApp);
      String xmlAsString = XMLUtils.DocumentToString(mismoXml);
      System.out.print(xmlAsString);
      System.out.print("Done");
   }
}