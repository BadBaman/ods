/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package cn.stylefeng.guns.sys.modular.file.entity;

import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Objects;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author stylefeng
 * @date 2020/6/7 22:15
 */
@TableName("sys_file_info")
public class SysFileInfo extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 文件存储位置（1:阿里云，2:腾讯云，3:minio，4:本地）
     */
    private Integer fileLocation;

    /**
     * 文件仓库
     */
    private String fileBucket;

    /**
     * 文件名称（上传时候的文件名）
     */
    private String fileOriginName;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 文件大小kb
     */
    private Long fileSizeKb;

    /**
     * 文件大小信息，计算后的
     */
    private String fileSizeInfo;

    /**
     * 存储到bucket的名称（文件唯一标识id）
     */
    private String fileObjectName;

    /**
     * 存储路径
     */
    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(Integer fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileBucket() {
        return fileBucket;
    }

    public void setFileBucket(String fileBucket) {
        this.fileBucket = fileBucket;
    }

    public String getFileOriginName() {
        return fileOriginName;
    }

    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Long getFileSizeKb() {
        return fileSizeKb;
    }

    public void setFileSizeKb(Long fileSizeKb) {
        this.fileSizeKb = fileSizeKb;
    }

    public String getFileSizeInfo() {
        return fileSizeInfo;
    }

    public void setFileSizeInfo(String fileSizeInfo) {
        this.fileSizeInfo = fileSizeInfo;
    }

    public String getFileObjectName() {
        return fileObjectName;
    }

    public void setFileObjectName(String fileObjectName) {
        this.fileObjectName = fileObjectName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysFileInfo that = (SysFileInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fileLocation, that.fileLocation) &&
                Objects.equals(fileBucket, that.fileBucket) &&
                Objects.equals(fileOriginName, that.fileOriginName) &&
                Objects.equals(fileSuffix, that.fileSuffix) &&
                Objects.equals(fileSizeKb, that.fileSizeKb) &&
                Objects.equals(fileSizeInfo, that.fileSizeInfo) &&
                Objects.equals(fileObjectName, that.fileObjectName) &&
                Objects.equals(filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, fileLocation, fileBucket, fileOriginName, fileSuffix, fileSizeKb, fileSizeInfo, fileObjectName, filePath);
    }
}
