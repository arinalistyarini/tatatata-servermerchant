/**
 * 
 */
package org.chamerling.heroku.servicemerchant;

import com.servermerchant.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	@WebMethod(operationName = "addTransaksi")
        public Boolean addTransaksi(@WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal, @WebParam(name = "barangJumlah") HashMapBarangJumlah barangJumlah);
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayTransaksi getListTransaksi();
        
        @WebMethod(operationName = "getTransaksiBarangByWaktu")
        public ArrayTransaksiBarang getTransaksiBarangByWaktu(@WebParam(name = "waktu")  String waktu);
        
        @WebMethod(operationName = "getListBarang")
        public ArrayBarang getListBarang();
        
        /*@WebMethod(operationName = "getBarang")
        public Barang getBarang(@WebParam(name = "idBarang") String idBarang);*/
        
        /*@WebMethod(operationName = "getTransaksiBarangByIDTransaksi")
        public ArrayList<TransaksiBarang> getTransaksiBarangByIDTransaksi(@WebParam(name = "idBarang") String idTransaksi);*/
}
