import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserModelSSWriteDemo {

    public static void main(String[] args) throws IOException {

        // 数据源
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"学号", "姓名", "性别", "专业"});
        data.add(new String[]{"1001", "小白", "女", "计算机科学与技术"});
        data.add(new String[]{"1002", "小黑", "男", "软件工程"});

        Workbook wb = new XSSFWorkbook();
        // 创建sheet
        Sheet sheet = wb.createSheet("Demo");

        for (int i = 0; i < data.size(); i++) {

            // 创建行
            Row row = sheet.createRow(i);
            String[] content = data.get(i);

            for (int j = 0; j < content.length; j++) {

                // 创建单元格
                if (0 != i && 0 == j) {
                    row.createCell(j).setCellValue(Double.valueOf(content[j]));
                    continue;
                }
                row.createCell(j).setCellValue(content[j]);
            }
        }

        // 生成Excel
        FileOutputStream out = new FileOutputStream("F:\\Demo.xlsx");
        wb.write(out);
        out.close();
    }
}