package bk.projectweb.springmvcshoppingcart.model;
 
import java.util.ArrayList;
import java.util.List;
 

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
 
public class PaginationResult<E> {
 
   private int totalRecords;
   private int currentPage;
   private List<E> list;
   private int maxResult;
   private int totalPages;
 
   private int maxNavigationPage;
 
   private List<Integer> navigationPages;
 
   // @page: 1, 2, ..
   //@SuppressWarnings lÃ m cho trÃ¬nh biÃªn dá»‹ch khÃ´ng cáº£nh bÃ¡o cÃ¡c lá»—i trong 1 method, vd nhÆ° 1 kiá»ƒu data Ä‘Ã£ lá»—i thá»�i
   @SuppressWarnings({ "rawtypes", "unchecked" })
public PaginationResult(Query query, int page, int maxResult, int maxNavigationPage) {
       //final int pageIndex = page - 1 < 0 ? 0 : page - 1; //Pháº£i cÃ³ cÃ¡i nÃ y vÃ¬ sang page khÃ¡c, nÃ³ láº¡i load /ProductList nhÆ°ng page khÃ¡c, default page = 1
	   final int pageIndex = page - 1;
	   int fromRecordIndex = pageIndex * maxResult;
       int maxRecordIndex = fromRecordIndex + maxResult;
 
       ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
 
       List results = new ArrayList();
       
       //Chuyá»ƒn tá»›i báº£n ghi Ä‘áº§u
       boolean hasResult = resultScroll.first();
 
       if (hasResult) {
           // Cuá»™n tá»›i vá»‹ trÃ­:
           hasResult = resultScroll.scroll(fromRecordIndex);
 
           if (hasResult) {
               do {
                   E record = (E) resultScroll.get(0);
                   results.add(record);
               } while (resultScroll.next()//
                       && resultScroll.getRowNumber() >= fromRecordIndex
                       && resultScroll.getRowNumber() < maxRecordIndex);
 
           }
      
           // Chuyá»ƒn tá»›i báº£n ghi cuá»‘i
           resultScroll.last();
       }
      
       // Tá»•ng sá»‘ báº£n ghi.
       this.totalRecords = resultScroll.getRowNumber() + 1;
       this.currentPage = pageIndex + 1;
       this.list = results;
       this.maxResult = maxResult;
 
       this.totalPages = (this.totalRecords / this.maxResult) + 1;
       this.maxNavigationPage = maxNavigationPage;
 
       if (maxNavigationPage < totalPages) {
           this.maxNavigationPage = maxNavigationPage;
       }
 
       this.calcNavigationPages();
   }
 
   private void calcNavigationPages() {
 
       this.navigationPages = new ArrayList<Integer>();
 
       int current = this.currentPage > this.totalPages ? this.totalPages : this.currentPage;
 
       int begin = current - this.maxNavigationPage / 2;
       int end = current + this.maxNavigationPage / 2;
 
  
       // Trang Ä‘áº§u tiÃªn
       navigationPages.add(1);
       if (begin > 2) {
        
           // DÃ¹ng cho '...'
           navigationPages.add(-1);
       }
 
       for (int i = begin; i < end; i++) {
           if (i > 1 && i < this.totalPages) {
               navigationPages.add(i);
           }
       }
 
       if (end < this.totalPages - 2) {
         
           // DÃ¹ng cho '...'
           navigationPages.add(-1);
       }
       // Trang cuá»‘i cÃ¹ng.
       navigationPages.add(this.totalPages);
   }
 
   public int getTotalPages() {
       return totalPages;
   }
 
   public int getTotalRecords() {
       return totalRecords;
   }
 
   public int getCurrentPage() {
       return currentPage;
   }
 
   public List<E> getList() {
       return list;
   }
 
   public int getMaxResult() {
       return maxResult;
   }
 
   public List<Integer> getNavigationPages() {
       return navigationPages;
   }
  
}