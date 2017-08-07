package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsStockOrderExecutionMapper;
import com.pbs.ams.web.model.AmsStockOrderExecution;
import com.pbs.ams.web.service.AmsStockOrderExecutionService;
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
* AmsStockOrderExecutionService实现
* Created by ams on 2017/8/3.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsStockOrderExecutionServiceImpl  implements AmsStockOrderExecutionService {

    private static Logger _log = LoggerFactory.getLogger(AmsStockOrderExecutionServiceImpl.class);

    @Autowired
    private AmsStockOrderExecutionMapper amsStockOrderExecutionMapper;

        @Override
        public List<Map> selectStockOrderExecutionWithDetail(Map map){
            return amsStockOrderExecutionMapper.selectStockOrderExecutionWithDetail(map);
        }
        @Override
        public int selectStockOrderExecutionWithDetailCount(Map map) {
            return amsStockOrderExecutionMapper.selectStockOrderExecutionWithDetailCount(map);
        }
        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsStockOrderExecution amsStockOrderExecution) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.insert(amsStockOrderExecution);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsStockOrderExecution amsStockOrderExecution) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.insertSelective(amsStockOrderExecution);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsStockOrderExecution selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsStockOrderExecution amsStockOrderExecution) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.updateByPrimaryKeySelective(amsStockOrderExecution);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsStockOrderExecution amsStockOrderExecution) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockOrderExecutionMapper.updateByPrimaryKey(amsStockOrderExecution);
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
        public int insertToAmsStockOrderExecutionSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsStockOrderExecutionMapper.insertToAmsStockOrderExecutionSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}