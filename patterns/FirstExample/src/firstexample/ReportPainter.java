package firstexample;

import java.util.List;

public class ReportPainter
{
    private ReportDAO dao;

    public void setDao(ReportDAO dao) {
        this.dao = dao;
    }
    
    protected List<String> getFromDB() {
        return dao.getProductList();
    }
    
    String drawReport() {
        List<String> f = getFromDB();
        return "";
    }
}
