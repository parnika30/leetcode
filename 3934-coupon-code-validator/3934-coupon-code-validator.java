class Solution {

    class Coupon {
    String code;
    String businessLine;
    
        public Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }


    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> res = new ArrayList<>();
        int n = code.length;

        Map<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);

        for(int i=0;i<n;i++){
            boolean hasValidChar = true;
            for (char c : code[i].toCharArray()) {
                if (!(Character.isLetterOrDigit(c) || c == '_' )) {
                    hasValidChar = false;
                    break;
                }
            }
        
                if(hasValidChar && code[i].length() !=0 &&
                (businessLine[i].equals("electronics")  || businessLine[i].equals("grocery") 
                || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")) &&
                (isActive[i])){
                    res.add(new Coupon(code[i], businessLine[i]));
                }  

        }

        res.sort((a, b) -> {
            int cmp = Integer.compare(map.get(a.businessLine), map.get(b.businessLine));
            if (cmp == 0) {
                return a.code.compareTo(b.code);
            }
            return cmp;
        });

        List<String> result = new ArrayList<>();
        for (Coupon c : res) {
            result.add(c.code);
        }

        return result;
    }
}