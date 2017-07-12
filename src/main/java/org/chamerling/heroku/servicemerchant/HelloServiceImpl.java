/**
 * 
 */
package org.chamerling.heroku.servicemerchant;

import com.firebase.client.Firebase;
import com.servermerchant.model.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @author chamerling
 * 
 */
public class HelloServiceImpl implements HelloService {
        private final String rootURL = "https://ta-merchant.firebaseio.com/";

	@WebMethod(operationName = "addTransaksi")
        public Boolean addTransaksi(@WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "barangJumlah") HashMapBarangJumlah barangJumlah){
            Firebase ref = new Firebase(rootURL);
            
            //nulis transaksi
            String waktu = System.currentTimeMillis() + "";
            String transaksiURL = "transaksi/" + waktu; // timestamp
            Firebase transaksiRef = ref.child(transaksiURL);
            Map<String, Object> transaction = new HashMap<String, Object>();
            transaction.put("nominal", nominal);
            transaction.put("no_kartu", idKartu);
            transaksiRef.updateChildren(transaction);
            
            //nulis transaksi_barang
            //iterate hashmap barang_jumlah
            /*if(barangJumlah.isEmpty()){
                System.out.println("kosong");
            }
            else{
                System.out.println("isi");
            }*/
            Set set = barangJumlah.getBarangJumlah().entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next(); // untuk tau mpe index mana
                //transaction.put((String) me.getKey(), (Integer) me.getValue());  // string: id_barang, int: jumlah barang yang dibeli
                String key = transaksiRef.push().getKey();
                String transaksiBarangURL = "transaksi/" + waktu + "/transaksi_barang/" + key;
                Firebase transaksiBRef = ref.child(transaksiBarangURL);
                
                Map<String, Object> transactionB = new HashMap<String, Object>();
                transactionB.put("id_barang", (String) me.getKey());
                transactionB.put("jumlah", (Integer) me.getValue());
                transaksiBRef.updateChildren(transactionB);
            }
            
            /*//nulis transaksi_barang
            Map<String, Object> transactionBarang = new HashMap<String, Object>();
            String transaksiBarangURL = "transaksi_barang/" + System.currentTimeMillis();
            Firebase transaksiBarangRef = ref.child(transaksiBarangURL);
            Map<String, Object> transactionBarang = new HashMap<String, Object>();
            
            //iterate hashmap barang_jumlah
            Set set = barang_jumlah.entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next(); // untuk tau mpe index mana
                transactionBarang.put((String) me.getKey(), (Integer) me.getValue());
            }
            transaksiBarangRef.updateChildren(transactionBarang);*/
            
            return true;
        }
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayTransaksi getListTransaksi(){
            try {
                URL url = new URL(rootURL + "transaksi.json");
                URLConnection con = url.openConnection();
                JSONTokener json = new JSONTokener(con.getInputStream());
                JSONObject obj = new JSONObject(json);
                Iterator<String> data = obj.keys();
                ArrayList<Transaksi> t = new ArrayList<Transaksi>();
                                
                while(data.hasNext()){
                    String waktu = data.next();
                    
                    JSONObject getTrans = obj.getJSONObject(waktu);

                    Transaksi transaksi = new Transaksi();
                    //transaksi.setBarangJumlah(null); --> dibikin method baru aja "getTransaksiBarangByIDTransaksi"
                    transaksi.setNominal(getTrans.getInt("nominal"));
                    transaksi.setIdKartu(getTrans.getString("no_kartu"));
                    transaksi.setWaktu(new Date(Long.parseLong(waktu)));
                    t.add(transaksi);
                }
                
                ArrayTransaksi result = new ArrayTransaksi();
                result.setTransaksis(t);
                
                return result;
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return null;
        }
        
        @WebMethod(operationName = "getTransaksiBarangByWaktu")
        public ArrayTransaksiBarang getTransaksiBarangByWaktu(@WebParam(name = "waktu")  String waktu){
            try {
                URL url = new URL(rootURL + "transaksi/" + waktu + "/transaksi_barang.json");
                URLConnection con = url.openConnection();
                JSONTokener json = new JSONTokener(con.getInputStream());
                JSONObject obj = new JSONObject(json);
                Iterator<String> data = obj.keys();
                ArrayList<TransaksiBarang> t = new ArrayList<TransaksiBarang>();
                                
                while(data.hasNext()){
                    String idTBrg = data.next();
                    
                    JSONObject getTrans = obj.getJSONObject(idTBrg);

                    TransaksiBarang tb = new TransaksiBarang();
                    tb.setIdBarang(getTrans.getString("id_barang"));
                    tb.setIdTransaksiBarang(idTBrg);
                    tb.setJumlah(getTrans.getInt("jumlah"));
                    
                    t.add(tb);                    
                }
                ArrayTransaksiBarang result = new ArrayTransaksiBarang();
                result.setTransaksiBarangs(t);
                
                return result;
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return null;
    }
        
        @WebMethod(operationName = "getListBarang")
        public ArrayBarang getListBarang(){
            try {
                URL url = new URL(rootURL + "barang.json");
                URLConnection con = url.openConnection();
                JSONTokener json = new JSONTokener(con.getInputStream());
                JSONObject obj = new JSONObject(json);
                Iterator<String> data = obj.keys();
                ArrayList<Barang> b = new ArrayList<Barang>();
                                
                while(data.hasNext()){
                    String idBar = data.next();
                    
                    JSONObject getBar = obj.getJSONObject(idBar);

                    Barang barang = new Barang();
                    barang.setHarga(getBar.getInt("harga"));
                    barang.setIdBarang(idBar);
                    barang.setNamaBarang(getBar.getString("nama_barang"));
                    b.add(barang);
                }    
                
                ArrayBarang result = new ArrayBarang();
                result.setBarangs(b);
                
                return result;
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return null;
        }
        
        //nanti
        /*@WebMethod(operationName = "getBarang")
        public Barang getBarang(@WebParam(name = "idBarang") String idBarang){
            try {
                URL url = new URL(rootURL + "barang/" + idBarang + ".json");
                URLConnection con = url.openConnection();
                JSONTokener json = new JSONTokener(con.getInputStream());
                JSONObject obj = new JSONObject(json);
                Barang b = new Barang();
                
                b.setHarga(obj.getInt("harga"));
                b.setIdBarang(idBarang);
                b.setNamaBarang("nama_barang");

                return b;
            } catch (IOException ex) {
                Logger.getLogger(HelloServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }*/
        
        
}
