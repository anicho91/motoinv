package com.company.MotoInvservice.service;

import com.company.MotoInvservice.util.feign.MotoFeign;
import com.company.MotoInvservice.util.model.Moto;
import com.company.MotoInvservice.viewmodel.MotoViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MotoServiceTest {

    @InjectMocks
    MotoService service;

    @Mock
    MotoFeign mFeign;

    static Moto moto = new Moto(
            1, new BigDecimal("500.00"), "vin num",
            "moto make", "moto model", "1992", "red"
    );

    @Before
    public void setUp() throws Exception {
        setUpFeignClientMock();
    }

    @Test
    public void testingToAddMoto() {
        Moto newMoto = moto;

        MotoViewModel mvm = new MotoViewModel();
        mvm.setPrice(newMoto.getPrice());
        mvm.setVin(newMoto.getVin());
        mvm.setMake(newMoto.getMake());
        mvm.setModel(newMoto.getModel());
        mvm.setYear(newMoto.getYear());
        mvm.setColor(newMoto.getColor());

        service.addMoto(mvm);
        mvm.setId(newMoto.getId());

        MotoViewModel fromService = service.getMoto(mvm.getId());

        assertEquals(fromService, mvm);

    }

    @Test
    public void testingToGetAllMoto() {
        Moto newMoto = moto;

        MotoViewModel mvm = new MotoViewModel();
        mvm.setPrice(newMoto.getPrice());
        mvm.setVin(newMoto.getVin());
        mvm.setMake(newMoto.getMake());
        mvm.setModel(newMoto.getModel());
        mvm.setYear(newMoto.getYear());
        mvm.setColor(newMoto.getColor());

        service.addMoto(mvm);
        mvm.setId(newMoto.getId());

        List<MotoViewModel> motos = service.getAllMoto();
        assertEquals(1, motos.size());

    }

    @Test
    public void testingToGetMoto() {

        Moto newMoto = moto;

        MotoViewModel mvm = new MotoViewModel();
        mvm.setPrice(newMoto.getPrice());
        mvm.setVin(newMoto.getVin());
        mvm.setMake(newMoto.getMake());
        mvm.setModel(newMoto.getModel());
        mvm.setYear(newMoto.getYear());
        mvm.setColor(newMoto.getColor());

        service.addMoto(mvm);
        mvm.setId(newMoto.getId());

        MotoViewModel fromService = service.getMoto(mvm.getId());

        assertEquals(fromService, mvm);
    }

    @Test
    public void testingToUpdateMoto() {

        Moto newMoto1 = moto;

        MotoViewModel mvm2 = new MotoViewModel();
        mvm2.setPrice(newMoto1.getPrice());
        mvm2.setVin(newMoto1.getVin());
        mvm2.setMake(newMoto1.getMake());
        mvm2.setModel(newMoto1.getModel());
        mvm2.setYear(newMoto1.getYear());
        mvm2.setColor(newMoto1.getColor());

        service.addMoto(mvm2);
        mvm2.setId(newMoto1.getId());

        MotoViewModel fromService = service.getMoto(mvm2.getId());
        mvm2.setColor("blue");
        service.updateMoto(mvm2);

        assertEquals(fromService, mvm2);

    }

    @Test
    public void testingPurchaseMoto(){

        Moto newMoto = moto;

        MotoViewModel mvm = new MotoViewModel();
        mvm.setPrice(newMoto.getPrice());
        mvm.setVin(newMoto.getVin());
        mvm.setMake(newMoto.getMake());
        mvm.setModel(newMoto.getModel());
        mvm.setYear(newMoto.getYear());
        mvm.setColor(newMoto.getColor());

        service.addMoto(mvm);
        mvm.setId(newMoto.getId());

        BigDecimal total = mvm.getPrice().multiply(new BigDecimal(".065"));
        total = total.add(mvm.getPrice());
        total = total.add(new BigDecimal("234"));
        total= total.add(new BigDecimal("395"));

        mvm.setTotalCost(total);

        assertEquals(total, new BigDecimal("1161.50000"));
    }

    @Test
    public void testingToDeleteMoto() {

        Moto newMoto = moto;

        MotoViewModel mvm = new MotoViewModel();
        mvm.setPrice(newMoto.getPrice());
        mvm.setVin(newMoto.getVin());
        mvm.setMake(newMoto.getMake());
        mvm.setModel(newMoto.getModel());
        mvm.setYear(newMoto.getYear());
        mvm.setColor(newMoto.getColor());

        service.addMoto(mvm);
        mvm.setId(newMoto.getId());

        service.deleteMoto(1);
        ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mFeign, times(1)).deleteMoto(intCaptor.capture());

        assertEquals(1, intCaptor.getValue().intValue());

    }

    private void setUpFeignClientMock(){
        Moto newMoto = new Moto(
                1, new BigDecimal("500.00"), "vin num",
                "moto make", "moto model", "1992", "red"
        );

        List<Moto> motos = new ArrayList<>();
        motos.add(newMoto);

        doReturn(newMoto).when(mFeign).getMoto(1);
        doReturn(motos).when(mFeign).getAllMoto();

    }
}