package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsProductPuMapper;
import com.pbs.ams.web.mappers.AmsProductMapper;
import com.pbs.ams.web.mappers.AmsProductUserMapper;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.amsProductPu;
import com.pbs.ams.web.model.AmsProductSnaps;
import com.pbs.ams.web.model.AmsProductUser;
import com.pbs.ams.web.service.AmsProductService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * AmsProductService实现
 * Created by ams on 2017/6/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductServiceImpl  implements AmsProductService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductServiceImpl.class);

    @Autowired
    private AmsProductMapper amsProductMapper;

    @Autowired
    private AmsProductPuMapper amsProductPuMapper;

    @Autowired
    private AmsProductUserMapper amsProductUserMapper;

    /**
     * This method by id delete data  通过id删除数据
     * @param productId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long productId) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsProductMapper.deleteByPrimaryKey(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    /**
     * This method by id delete data  通过id删除数据
     * @param ids
     * @return
     */
    @Override
    public int deleteByPrimaryKeys(List<Long> ids) {
        if (null != ids && ids.size() >0) {
            int count = 0;
            for (long id : ids) {
                //先做查询再去删除原表数据和插入快照
                AmsProduct amsProduct = amsProductMapper.selectByPrimaryKey(id);
                if (amsProduct != null) {
                    AmsProductSnaps amsProductSnaps = new AmsProductSnaps();
                    try {
                        PropertyUtils.copyProperties(amsProductSnaps, amsProduct);
                        //向快照表插入数据
                        int snapshotResult = amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                        count += amsProductMapper.deleteByPrimaryKey(id);
                    } catch (IllegalAccessException e) {//checkException
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            return count;
        }
        return 0;
    }

    /**
     * This method by id query data  通过id查询数据
     * @param id
     * @return
     */
    @Override
    public AmsProduct selectByPrimaryKey(Long id) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsProductMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return null;
    }

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    @Override
    public List<Map> selectProductWithDetail(Map map){

        return amsProductMapper.selectProductWithDetail(map);
    }

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    @Override
    public int selectProductWithDetailCount(Map map){

        return amsProductMapper.selectProductWithDetailCount(map);
    }

    /**
     * 修改账号状态
     * @param id 账号id
     * @param status 账号状态
     * @return
     */
    @Override
    public int updateProductStatusById(Long id, Integer status) {
        if (null != id) {
            //先做查询再去更新原表数据和插入快照
            AmsProduct oldamsProduct = amsProductMapper.selectByPrimaryKey(id);
            if (null != oldamsProduct){
                AmsProductSnaps amsProductSnaps=new AmsProductSnaps();
                try {
                    PropertyUtils.copyProperties(amsProductSnaps, oldamsProduct);
                    //向快照表插入数据
                    int snapshotResult=amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        oldamsProduct.setProductStatus(status);
                        return amsProductMapper.updateAmsProduct(oldamsProduct);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    @Override
    public int selectProductCount(Map map){

        return amsProductMapper.selectProductCount(map);
    }

    /**
     * This method is used to bind Account and Product
     * @param amsProductPu
     * @return
     */
    @Override
    public int insertAmsProductAccount(amsProductPu amsProductPu) {
        return amsProductPuMapper.insert(amsProductPu);
    }

    /**
     *query product by some companys(sql:companyId in ...)
     * @param paramMaps 参数
     * @return
     */
    @Override
    public List<Map> selectProduct(Map<String, Object> paramMaps) {

        return amsProductMapper.selectProduct(paramMaps);
    }

    /**
     *insert a product and product-user relation
     * @param amsProduct
     * @param amsProductUser
     * @return insert count
     */
    @Override
    public int insertProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser) {
        if (null != amsProduct && null != amsProductUser) {
            int result;
            int count = amsProductMapper.insertSelective(amsProduct);
            if (count > 0) {
                result = amsProductUserMapper.insert(amsProductUser);
                if (result > 0) {
                    return result;
                }
            }
        }
        return 0;
    }

    /**
     * update a product and product-user relation
     *
     * @param amsProduct
     * @param amsProductUser
     * @return update count
     */
    @Override
    public int updateProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser) {
        if (null != amsProduct && null != amsProductUser) {
            //先做查询再去更新原表数据和插入快照
            AmsProduct oldamsProduct=amsProductMapper.selectByPrimaryKey(amsProduct.getProductId());
            if(null!=oldamsProduct){
                AmsProductSnaps amsProductSnaps=new AmsProductSnaps();
                try {
                    PropertyUtils.copyProperties(amsProductSnaps, oldamsProduct);
                    //向快照表插入数据
                    int snapshotResult=amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                    if(snapshotResult>0){//当插入成功后再更新原数据
                        int count=amsProductMapper.updateAmsProduct(amsProduct);
                        if(count>0){
                            return amsProductUserMapper.updateByPrimaryKeySelective(amsProductUser);
                        }
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

}