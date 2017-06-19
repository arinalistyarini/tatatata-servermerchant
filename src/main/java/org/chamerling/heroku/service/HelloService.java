/**
 * 
 */
package org.chamerling.heroku.service;

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
        public Boolean addTransaksi(@WebParam(name = "nominal") int nominal, @WebParam(name = "barangJumlah") HashMap<String, Integer> barangJumlah);
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayList<Transaksi> getListTransaksi();
        
        @WebMethod(operationName = "getListBarang")
        public ArrayList<Barang> getListBarang();
        
        @WebMethod(operationName = "getBarang")
        public Barang getBarang(@WebParam(name = "idBarang") String idBarang);
        
        @WebMethod(operationName = "getTransaksiBarangByIDTransaksi")
        public ArrayList<TransaksiBarang> getTransaksiBarangByIDTransaksi(@WebParam(name = "idBarang") String idTransaksi);
}
