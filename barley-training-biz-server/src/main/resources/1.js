function value(data) {
    return data == null ? '' : utils.valueToString(data);
}
// 读取
var workbook = excel.readTemplate();
// 读取sheet 页
var sheet = workbook.getSheetAt(0);

// 查询数据
var sql = params.get('variable').get('DATALIST');
var dataList = mybatis.query('DEFAULT', sql, params);

// 写入数据
for(var p = 0; p < dataList.length; p++) {
    var dataItem = dataList.get(p);
    var row = sheet.getRow(1 + p);
    if (row == null) {
        row = sheet.createRow(1 + p);
    }
    // 表示你有多少列
    for (var i = 0; i < 20; i++ ) {
        if (row.getCell(i) == null) {
            row.createCell(i).setCellValue('');
        }
    }
    row.getCell(0).setCellValue(value(dataItem.get('字段名称')));
    row.getCell(1).setCellValue(value(dataItem.get('字段名称')));
    row.getCell(2).setCellValue(value(dataItem.get('字段名称')));
    row.getCell(3).setCellValue(value(dataItem.get('字段名称')));
    row.getCell(4).setCellValue(value(dataItem.get('字段名称')));
    row.getCell(5).setCellValue(value(dataItem.get('字段名称')));
}

// 保存
excel.save(workbook);