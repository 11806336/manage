package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsProductUnitExtMapper;
import com.pbs.ams.web.model.AmsProductUnitExt;
import com.pbs.ams.web.service.AmsProductUnitExtService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* com.ruixin:pbs-ams-management:war:1.0Service实现
* Created by ams on 2017/7/13.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductUnitExtServiceImpl  implements AmsProductUnitExtService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductUnitExtServiceImpl.class);

    @Autowired
    private AmsProductUnitExtMapper amsProductUnitExtMapper;


    @Override
    public List<Map> selectAmsProductUnitExtWithDetail(Map map) {

        return amsProductUnitExtMapper.selectAmsProductUnitExtWithDetail(map);
    }

    @Override
    public long selectAmsProductUnitExtWithDetailCount(Map map) {
        return amsProductUnitExtMapper.selectAmsProductUnitExtWithDetailCount(map);
    }


    @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsProductUnitExt amsProductUnitExt) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.insert(amsProductUnitExt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsProductUnitExt amsProductUnitExt) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.insertSelective(amsProductUnitExt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsProductUnitExt selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsProductUnitExt amsProductUnitExt) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.updateByPrimaryKeySelective(amsProductUnitExt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsProductUnitExt amsProductUnitExt) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitExtMapper.updateByPrimaryKey(amsProductUnitExt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int deleteByPrimaryKeys(String ids) {
            try {
                if (StringUtils.isBlank(ids)) {
                    return 0;
                }
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                String[] idArray = ids.split("-");
                int count = 0;
                for (String idStr : idArray) {
                    if (StringUtils.isBlank(idStr)) {
                        continue;
                    }
                    Long id = Long.parseLong(idStr);
                    //count += amsStockAccountMapper.deleteByPrimaryKey(id);
                }
                return count;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                DynamicDataSource.clearDataSource();
                return 0;
        }


        /**
        * MANDATORY:该方法只能在一个已存在的事务中执行.
        * @return
        */
        @Override
        @Transactional(propagation = Propagation.MANDATORY)
        public int insertToAmsProductUnitExtSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsProductUnitExtMapper.insertTocom.ruixin:pbs-ams-management:war:1.0Snaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}