class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2-ax1, b1 = ay2-ay1 ;
        int area1 = l1*b1;
        int l2 = bx2-bx1, b2 = by2-by1 ;
        int area2 = l2*b2;
        
        // find the cordinates of common rectangle
        int cx1 = Math.max(ax1,bx1), cy1 = Math.max(ay1,by1);
        int cx2 = Math.min(ax2,bx2), cy2 = Math.min(ay2,by2);
        int l3 = (cx2-cx1), b3 = (cy2-cy1); //l & b of common rectangle
        int area3 = 0;
        
        if(l3>0 && b3 >0){
             area3 = l3*b3;
        }
        
        return (area1+area2) - area3;
    }
}