package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsProductUnitMapper;
import com.pbs.ams.web.model.AmsProductUnit;
import com.pbs.ams.web.model.AmsProductUnitSnaps;
import com.pbs.ams.web.service.AmsProductUnitService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
* AmsTradeAccountService实现
* Created by ams on 2017/6/29.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductUnitServiceImpl implements AmsProductUnitService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductUnitServiceImpl.class);

    @Autowired
    private AmsProductUnitMapper amsProductUnitMapper;

        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insert(AmsProductUnit amsProductUnit) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitMapper.insert(amsProductUnit);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsProductUnit amsProductUnit) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitMapper.insertSelective(amsProductUnit);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public AmsProductUnit selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }

        @Override
        public int updateByPrimaryKeySelective(AmsProductUnit amsProductUnit) {
            if (null != amsProductUnit) {
                //先做查询再去更新原表数据和插入快照
                AmsProductUnit oldamsProductUnit = amsProductUnitMapper.selectByPrimaryKey(amsProductUnit.getProductUnitId());
                if (null != oldamsProductUnit) {
                    AmsProductUnitSnaps amsProductUnitSnaps = new AmsProductUnitSnaps();
                    try {
                        PropertyUtils.copyProperties(amsProductUnitSnaps, oldamsProductUnit);
                        //向快照表插入数据
                        int snapshotResult = amsProductUnitMapper.insertIntoAmsProductUnitSnaps(amsProductUnitSnaps);
                        if (snapshotResult > 0) {//当插入成功后再更新原数据
                            return amsProductUnitMapper.updateByPrimaryKeySelective(amsProductUnit);
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
    @Override
    public int updateAccountStatusById(Long id, Integer status) {
        if (null != id) {
            //先做查询再去更新原表数据和插入快照
            AmsProductUnit oldamsProductUnit = amsProductUnitMapper.selectByPrimaryKey(id);
            if (null != oldamsProductUnit){
                AmsProductUnitSnaps amsProductUnitSnaps = new AmsProductUnitSnaps();
                try {
                    PropertyUtils.copyProperties(amsProductUnitSnaps, oldamsProductUnit);
                    //向快照表插入数据
                    int snapshotResult = amsProductUnitMapper.insertIntoAmsProductUnitSnaps(amsProductUnitSnaps);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        oldamsProductUnit.setTradeAccountStatus(String.valueOf(status));
                        return amsProductUnitMapper.updateByPrimaryKeySelective(oldamsProductUnit);
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
        @Override
        public int updateByPrimaryKey(AmsProductUnit amsProductUnit) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductUnitMapper.updateByPrimaryKey(amsProductUnit);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int deleteByPrimaryKeys(List<Long> ids) {
            if (null != ids && ids.size() >0) {
                int count = 0;
                for (long id : ids) {
                    //先做查询再去删除原表数据和插入快照
                    AmsProductUnit amsProductUnit = amsProductUnitMapper.selectByPrimaryKey(id);
                    if (amsProductUnit != null) {
                        AmsProductUnitSnaps amsProductUnitSnaps = new AmsProductUnitSnaps();
                        try {
                            PropertyUtils.copyProperties(amsProductUnitSnaps, amsProductUnit);
                            //向快照表插入数据
                            int snapshotResult = amsProductUnitMapper.insertIntoAmsProductUnitSnaps(amsProductUnitSnaps);
                            count += amsProductUnitMapper.deleteByPrimaryKey(id);
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
        * MANDATORY:该方法只能在一个已存在的事务中执行.
        * @return
        */
        @Override
        @Transactional(propagation = Propagation.MANDATORY)
        public int insertIntoAmsProductUnitSnaps(AmsProductUnitSnaps amsProductUnitSnaps) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

    @Override
    public List<Map> selectProductUnitWithDetail(Map map) {
        return amsProductUnitMapper.selectProductUnitWithDetail(map);
    }

    @Override
    public int selectProductUnitWithDetailCount(Map map) {
        return amsProductUnitMapper.selectProductUnitWithDetailCount(map);
    }

    @Override
    public AmsProductUnit selectProductUnitByUnit(Long Unit) {
        return amsProductUnitMapper.selectProductUnitByUnit(Unit);
    }
}