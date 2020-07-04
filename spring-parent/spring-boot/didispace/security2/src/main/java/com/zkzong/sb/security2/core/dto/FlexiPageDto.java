package com.zkzong.sb.security2.core.dto;

/**
 * Created by Zong on 2017/6/2.
 */
public class FlexiPageDto {

    public static final Integer MAX_PAGE_SIZE = 100;
    public static final Integer SHORT_PAGE_SIZE = 5;
    public static final String SORTORDER_ASC = "asc";

    private Integer page;
    private Integer rp = 10;
    private Integer rowCount;
    private String sortName;
    private String sortOrder = "desc";

    public FlexiPageDto() {
    }

    public FlexiPageDto(Integer page, Integer rp) {
        this.page = page;
        this.rp = rp;
    }

    public FlexiPageDto(Integer page, Integer rp, String sortName) {
        this.page = page;
        this.rp = rp;
        this.sortName = sortName;
    }

    public FlexiPageDto(Integer page, Integer rp, String sortName, String sortOrder) {
        this.page = page;
        this.rp = rp;
        this.sortName = sortName;
        this.sortOrder = sortOrder;
    }

    public static FlexiPageDto createMaxPageDto() {
        FlexiPageDto flexiPageDto = new FlexiPageDto();
        flexiPageDto.setRp(MAX_PAGE_SIZE).setPage(1);
        return flexiPageDto;
    }

    public static FlexiPageDto generateFlexiPageDto(Integer page, Integer rp, String orderBy) {
        FlexiPageDto flexiPageDto = new FlexiPageDto(page, rp);
        if (null != orderBy  && "" != orderBy.trim()) {
            String[] orderBys = orderBy.split("_");
            flexiPageDto.setSortName(orderBys[0]);
            flexiPageDto.setSortOrder(orderBys[1]);
        }
        return flexiPageDto;
    }

    public Integer getOffset() {
        return (this.getPage() - 1) * this.getRp();
    }

    public Integer getTotalPage() {
        if (null == rowCount) {
            return 0;
        }
        int totalPage = rowCount / rp;
        int remainder = rowCount % rp;
        if (rowCount > 0 && totalPage == 0) {
            totalPage = 1;
            return totalPage;
        }
        if (remainder > 0) {
            totalPage++;
            return totalPage;
        }
        return totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public FlexiPageDto setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getRp() {
        return rp;
    }

    public FlexiPageDto setRp(Integer rp) {
        this.rp = rp;
        return this;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public FlexiPageDto setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    public String getSortName() {
        return sortName;
    }

    public FlexiPageDto setSortName(String sortName) {
        this.sortName = sortName;
        return this;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public FlexiPageDto setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public String getSortString() {
        if (null == sortName) {
            return null;
        }
        String[] fields = this.getSortName().split("_");
        String[] fieldsorts = this.getSortOrder().split("_");
        if (fields.length != fieldsorts.length) {
            throw new RuntimeException("排序规则不一致");
        }

        String sql = "";
        for (int index = 0; index < fields.length; index++) {
            sql = sql + " " + fields[index] + " " + fieldsorts[index];
        }
        return sql;
    }
}
