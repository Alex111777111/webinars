package firstexample;

import java.util.ArrayList;
import java.util.List;

public class FakeReportDAO implements ReportDAO
{

    @Override
    public List<String> getProductList() {
        return new ArrayList<String>();
    }
    
}
