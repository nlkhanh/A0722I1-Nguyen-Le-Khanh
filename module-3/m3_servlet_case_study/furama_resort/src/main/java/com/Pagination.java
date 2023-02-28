package com;

import furama_resort.service.IFuramaService;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
    private Pagination() {
    }

    public static int getOffset(int recordLimit, int page) {
        return (page - 1) * recordLimit;
    }

    public static int getNumberOfPages(IFuramaService furamaService, int recordLimit, String typeName, String search ) {
        int numberOfList = 0;
        if (furamaService != null) {
            if (search != null) {
                numberOfList = furamaService.getSearch(typeName, search).size();
            } else {
                numberOfList = furamaService.getAll(typeName).size();
            }
        }
        boolean checkNumberOfPages = (numberOfList % recordLimit) == 0;
        if (checkNumberOfPages) {
            return (numberOfList / recordLimit);
        }
        return (numberOfList / recordLimit) + 1;
    }

    public static List<Integer> getPageList(int pageLimit, int page, int numberOfPages) {
        List<Integer> pageList = new ArrayList<>();

        int pageGroup = page / pageLimit;
        boolean checkPageLists = (page % pageLimit) != 0;
        if (checkPageLists) {
            pageGroup++;
        }

        int pageMax;
        int pageMin;
        if (numberOfPages <= pageLimit) {
            pageMin = 1;
            pageMax = numberOfPages;
        } else {
            pageMax = pageGroup * pageLimit;
            pageMin = pageMax - pageLimit + 1;
            if (pageMax > numberOfPages) {
                pageMax = numberOfPages;
            }
        }
        for (int i = pageMin; i <= pageMax; i++) {
            pageList.add(i);
        }
        return pageList;
    }

    public static List<?> getList(IFuramaService furamaService, int recordLimit, String typeName, int offset, String search) {
        if (furamaService != null) {
            if (search != null) {
                return furamaService.getSearchPagination(typeName, search, offset, recordLimit);
            } else {
                return furamaService.getAllPagination(typeName, offset, recordLimit);
            }
        }
        return null;
    }
}
