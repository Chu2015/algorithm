import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        
        int len = lineList.size();
        boolean[] been = new boolean[len];
        //规则1
        for(int i=0;i<len;i++){
        	List<Integer> temp = new ArrayList<Integer>();
        	if(!been[i]) {
        		UnilateralLine current= lineList.get(i);
            	String ecen = current.getECen();
            	String scen = current.getSCen();
            	String type = current.getTType();
            	for(int j=i;j<len;j++ ) {
            		if(!been[j]) {
                		UnilateralLine com = lineList.get(j);
                		if(com.getECen().equals(scen) && com.getSCen().equals(ecen)) {
                			if(com.getTType().equals(current.getTType())) {
                				result.add(current.getId()+com.getId());
                				been[j] = true;
                				been[i] = true;
                				break;
                			}else {
                    			temp.add(j);
                    		}
                		}
            		}
            	}
            	if(!been[i] && current.getTType()=="17.5m" && temp.size()>1) {
            		int in = temp.get(0);
            		int in2 = temp.get(1);
            		been[in] = true;
            		been[in2] = true;
            		been[i] = true;
            		result.add(current.getId()+lineList.get(in).getId()+lineList.get(in2).getId());
            	}
        	}
        }
        for(int i=0;i<len;i++){
        	List<Integer> temp = new ArrayList<Integer>();
        	if(!been[i]) {
        		UnilateralLine current= lineList.get(i);
            	String ecen = current.getECen();
            	String scen = current.getSCen();
            	String type = current.getTType();
            	for(int j=i;j<len;j++ ) {
            		if(!been[j]) {
                		UnilateralLine com = lineList.get(j);
                		if(com.getSCen().equals(ecen)) {
                			temp.add(j);
                		}
            		}
            	}
            	for(int k=0;k<temp.size();k++) {
            		UnilateralLine current2 = lineList.get(temp.get(k));
                	String ecen2 = current.getECen();
                	String scen2 = current.getSCen();
                	String type2 = current.getTType();
            		for(int m=0;m<len;m++) {
            			if(!been[i]) {
            				UnilateralLine com2 = lineList.get(m);
            				if(com2.getSCen().equals(current2.getECen()) && com2.getECen().equals(current.getSCen())) {
            					been[m]=true;
            					been[k]=true;
            					been[i]=true;
            					result.add(current.getId()+current2.getId()+com2.getId());
            				}
            			}
            		}
            	}
        	}
        }
        for(int i=0;i<len;i++){
        	List<Integer> temp = new ArrayList<Integer>();
        	if(!been[i]) {
        		UnilateralLine current= lineList.get(i);
            	String ecen = current.getECen();
            	String scen = current.getSCen();
            	String type = current.getTType();
            	for(int j=i;j<len;j++ ) {
            		if(!been[j]) {
                		UnilateralLine com = lineList.get(j);
                		if(com.getECen().equals(scen)) {
                			temp.add(j);
                		}
            		}
            	}
            	for(int k=0;k<temp.size();k++) {
            		UnilateralLine current2 = lineList.get(temp.get(k));
                	String ecen2 = current.getECen();
                	String scen2 = current.getSCen();
                	String type2 = current.getTType();
                	if(current2.getSPro()==current.getEPro()) {
                		been[i]=true;
    					been[k]=true;
                		result.add(current.getId()+current2.getId());
                	}
            	}
        	}
        }
        
        return result;
    }
    public static class UnilateralLine {
		private String id;
		private String sCen;//出发分拨
		private String sPro;//出发省
		private String eCen;//到达分拨
		private String ePro;//到达省
		//9.6m/17.5m
		private String tType;//车型
		public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
		            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
		public String getId() {return id;}
		public void setId(String id) {this.id = id;}
		public String getSCen() {return sCen;}
		public void setSCen(String ePro) {this.ePro = ePro;}
		public String getSPro() {return sPro;}
		public void setSPro(String sPro) {this.sPro = sPro;}
		public String getECen() {return eCen;}
		public void setECen(String eCen) {this.eCen = eCen;}
		public String getEPro() {return ePro;}
		public void setEPro(String ePro) {this.ePro = ePro;}
		public String getTType() {return tType;}
		public void setTType(String tType) {this.tType = tType;}
    }
}