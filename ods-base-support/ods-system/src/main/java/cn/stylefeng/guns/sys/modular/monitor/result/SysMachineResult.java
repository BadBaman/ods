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
package cn.stylefeng.guns.sys.modular.monitor.result;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 系统属性结果集
 *
 * @author xuyuxiang
 * @date 2020/6/5 15:02
 */
public class SysMachineResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统信息
     */
    private SysOsInfo sysOsInfo;

    /**
     * Java信息
     */
    private SysJavaInfo sysJavaInfo;

    /**
     * JVM内存信息
     */
    private SysJvmMemInfo sysJvmMemInfo;

    public SysMachineResult() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SysOsInfo getSysOsInfo() {
        return sysOsInfo;
    }

    public void setSysOsInfo(SysOsInfo sysOsInfo) {
        this.sysOsInfo = sysOsInfo;
    }

    public SysJavaInfo getSysJavaInfo() {
        return sysJavaInfo;
    }

    public void setSysJavaInfo(SysJavaInfo sysJavaInfo) {
        this.sysJavaInfo = sysJavaInfo;
    }

    public SysJvmMemInfo getSysJvmMemInfo() {
        return sysJvmMemInfo;
    }

    public void setSysJvmMemInfo(SysJvmMemInfo sysJvmMemInfo) {
        this.sysJvmMemInfo = sysJvmMemInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMachineResult that = (SysMachineResult) o;
        return Objects.equals(sysOsInfo, that.sysOsInfo) &&
                Objects.equals(sysJavaInfo, that.sysJavaInfo) &&
                Objects.equals(sysJvmMemInfo, that.sysJvmMemInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysOsInfo, sysJavaInfo, sysJvmMemInfo);
    }

    @Override
    public String toString() {
        return "SysMachineResult{" +
                "sysOsInfo=" + sysOsInfo +
                ", sysJavaInfo=" + sysJavaInfo +
                ", sysJvmMemInfo=" + sysJvmMemInfo +
                '}';
    }

    /**
     * 系统信息内部类
     *
     * @author xuyuxiang
     * @date 2020/6/5 15:19
     */
    @NoArgsConstructor
    public static class SysOsInfo {

        /**
         * 系统名称
         */
        private String osName;

        /**
         * 系统架构
         */
        private String osArch;

        /**
         * 系统版本
         */
        private String osVersion;

        /**
         * 主机名称
         */
        private String osHostName;

        /**
         * 主机ip地址
         */
        private String osHostAddress;

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }

        public String getOsArch() {
            return osArch;
        }

        public void setOsArch(String osArch) {
            this.osArch = osArch;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getOsHostName() {
            return osHostName;
        }

        public void setOsHostName(String osHostName) {
            this.osHostName = osHostName;
        }

        public String getOsHostAddress() {
            return osHostAddress;
        }

        public void setOsHostAddress(String osHostAddress) {
            this.osHostAddress = osHostAddress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SysOsInfo sysOsInfo = (SysOsInfo) o;
            return Objects.equals(osName, sysOsInfo.osName) &&
                    Objects.equals(osArch, sysOsInfo.osArch) &&
                    Objects.equals(osVersion, sysOsInfo.osVersion) &&
                    Objects.equals(osHostName, sysOsInfo.osHostName) &&
                    Objects.equals(osHostAddress, sysOsInfo.osHostAddress);
        }

        @Override
        public int hashCode() {
            return Objects.hash(osName, osArch, osVersion, osHostName, osHostAddress);
        }

        @Override
        public String toString() {
            return "SysOsInfo{" +
                    "osName='" + osName + '\'' +
                    ", osArch='" + osArch + '\'' +
                    ", osVersion='" + osVersion + '\'' +
                    ", osHostName='" + osHostName + '\'' +
                    ", osHostAddress='" + osHostAddress + '\'' +
                    '}';
        }
    }

    /**
     * JVM信息内部类
     *
     * @author xuyuxiang
     * @date 2020/6/5 15:19
     */
    public static class SysJavaInfo {

        /**
         * 虚拟机名称
         */
        private String jvmName;

        /**
         * 虚拟机版本
         */
        private String jvmVersion;

        /**
         * 虚拟机供应商
         */
        private String jvmVendor;

        /**
         * java名称
         */
        private String javaName;

        /**
         * java版本
         */
        private String javaVersion;

        public SysJavaInfo() {
        }

        public String getJvmName() {
            return jvmName;
        }

        public void setJvmName(String jvmName) {
            this.jvmName = jvmName;
        }

        public String getJvmVersion() {
            return jvmVersion;
        }

        public void setJvmVersion(String jvmVersion) {
            this.jvmVersion = jvmVersion;
        }

        public String getJvmVendor() {
            return jvmVendor;
        }

        public void setJvmVendor(String jvmVendor) {
            this.jvmVendor = jvmVendor;
        }

        public String getJavaName() {
            return javaName;
        }

        public void setJavaName(String javaName) {
            this.javaName = javaName;
        }

        public String getJavaVersion() {
            return javaVersion;
        }

        public void setJavaVersion(String javaVersion) {
            this.javaVersion = javaVersion;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SysJavaInfo that = (SysJavaInfo) o;
            return Objects.equals(jvmName, that.jvmName) &&
                    Objects.equals(jvmVersion, that.jvmVersion) &&
                    Objects.equals(jvmVendor, that.jvmVendor) &&
                    Objects.equals(javaName, that.javaName) &&
                    Objects.equals(javaVersion, that.javaVersion);
        }

        @Override
        public int hashCode() {
            return Objects.hash(jvmName, jvmVersion, jvmVendor, javaName, javaVersion);
        }

        @Override
        public String toString() {
            return "SysJavaInfo{" +
                    "jvmName='" + jvmName + '\'' +
                    ", jvmVersion='" + jvmVersion + '\'' +
                    ", jvmVendor='" + jvmVendor + '\'' +
                    ", javaName='" + javaName + '\'' +
                    ", javaVersion='" + javaVersion + '\'' +
                    '}';
        }
    }

    /**
     * JVM内存信息
     *
     * @author xuyuxiang
     * @date 2020/6/5 15:19
     */
    public static class SysJvmMemInfo {

        /**
         * 最大内存
         */
        private String jvmMaxMemory;

        /**
         * 可用内存
         */
        private String jvmUsableMemory;

        /**
         * 总内存
         */
        private String jvmTotalMemory;

        /**
         * 已使用内存
         */
        private String jvmUsedMemory;

        /**
         * 空余内存
         */
        private String jvmFreeMemory;

        /**
         * 使用率
         */
        private String jvmMemoryUsedRate;

        public SysJvmMemInfo() {
        }

        public String getJvmMaxMemory() {
            return jvmMaxMemory;
        }

        public void setJvmMaxMemory(String jvmMaxMemory) {
            this.jvmMaxMemory = jvmMaxMemory;
        }

        public String getJvmUsableMemory() {
            return jvmUsableMemory;
        }

        public void setJvmUsableMemory(String jvmUsableMemory) {
            this.jvmUsableMemory = jvmUsableMemory;
        }

        public String getJvmTotalMemory() {
            return jvmTotalMemory;
        }

        public void setJvmTotalMemory(String jvmTotalMemory) {
            this.jvmTotalMemory = jvmTotalMemory;
        }

        public String getJvmUsedMemory() {
            return jvmUsedMemory;
        }

        public void setJvmUsedMemory(String jvmUsedMemory) {
            this.jvmUsedMemory = jvmUsedMemory;
        }

        public String getJvmFreeMemory() {
            return jvmFreeMemory;
        }

        public void setJvmFreeMemory(String jvmFreeMemory) {
            this.jvmFreeMemory = jvmFreeMemory;
        }

        public String getJvmMemoryUsedRate() {
            return jvmMemoryUsedRate;
        }

        public void setJvmMemoryUsedRate(String jvmMemoryUsedRate) {
            this.jvmMemoryUsedRate = jvmMemoryUsedRate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SysJvmMemInfo that = (SysJvmMemInfo) o;
            return Objects.equals(jvmMaxMemory, that.jvmMaxMemory) &&
                    Objects.equals(jvmUsableMemory, that.jvmUsableMemory) &&
                    Objects.equals(jvmTotalMemory, that.jvmTotalMemory) &&
                    Objects.equals(jvmUsedMemory, that.jvmUsedMemory) &&
                    Objects.equals(jvmFreeMemory, that.jvmFreeMemory) &&
                    Objects.equals(jvmMemoryUsedRate, that.jvmMemoryUsedRate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(jvmMaxMemory, jvmUsableMemory, jvmTotalMemory, jvmUsedMemory, jvmFreeMemory, jvmMemoryUsedRate);
        }

        @Override
        public String toString() {
            return "SysJvmMemInfo{" +
                    "jvmMaxMemory='" + jvmMaxMemory + '\'' +
                    ", jvmUsableMemory='" + jvmUsableMemory + '\'' +
                    ", jvmTotalMemory='" + jvmTotalMemory + '\'' +
                    ", jvmUsedMemory='" + jvmUsedMemory + '\'' +
                    ", jvmFreeMemory='" + jvmFreeMemory + '\'' +
                    ", jvmMemoryUsedRate='" + jvmMemoryUsedRate + '\'' +
                    '}';
        }
    }
}
