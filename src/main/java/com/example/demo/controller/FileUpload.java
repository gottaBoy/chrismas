package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FileUpload {
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("fileupload");
        return mv;
    }
	
	@RequestMapping(value = "/fileupload",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request, HttpServletResponse response){
		
		return "success";
	}
	
	//上传附件:第一次从前台传来的附件组id为空，调用saveAttachment函数后生产一个附件组id和附件id；将附件组id返回页面并存在一个隐藏框里；第二次上传附件时，取出隐藏框里的附件组id随着请求一起传到后台，这时再调用saveAttachment函数时，不会生产新的附件组id，从而确保所有的附件有相同的附件组id。
//	@RequestMapping(value = "/fileupload",method=RequestMethod.POST)
//	public void uploadFile(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request, HttpServletResponse response){
//		String attaSetId = request.getParameter("attaSetId");
//		AttachmentVO attaVO = this.getBaseBS().saveAttachment(file, attaSetId, this.getCurrentUser());
//		this.outResponse(response, UtilJson.JavaBean2Json(attaVO));
//	}
	//附件删除
//	@RequestMapping(value = "/deleteFile")  
//	public void deleteFile(HttpServletRequest request,HttpServletResponse response){
//		String attaSetId = request.getParameter("attaSetId");
//		String attaId = request.getParameter("attaId");
//		this.getBaseBS().deleteAttachment(attaId, attaSetId);
//	}
	 /**saveAttachment函数
         * 附件上传
	 * @param file
	 * @param attaSetId
	 * @return
	 */
//	public AttachmentVO saveAttachment(CommonsMultipartFile file,String attaSetId,LogonUserVO user){
//		if(attaSetId == null || attaSetId.trim().length() == 0){
//			attaSetId = this.txNewUUID();
//			this.getBaseDAO().insertMyBatisObj("framework.insertAttaSet", attaSetId);
//		}
//		AttachmentVO attaVO = null;
//		//保存文件至硬盘，改文件存储名称
//		String rootPath = "";
//		//获取字典表中，附件文件保存的根路径
//	    DictionaryVO dic = this.queryDictionaryOne(Constants.ATTACHMENT_ROOT_PATH);
//	    if(dic != null && dic.getDictionaryValue() != null && dic.getDictionaryValue().trim().length()>0){
//	    	rootPath = dic.getDictionaryValue();
//	    	String suffix = "";
//	    	if(file.getOriginalFilename().indexOf(".") != -1){
//	    		suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//	    		//保存于：附件根路径(path)+附件组ID(目录)+重命名后的文件
//	    		String relativePath = attaSetId+File.separator+UtilDate.getCurrentTimeString()+suffix;
//	    		File saveFile = new File(rootPath+File.separator+relativePath);
//	    		File parentPath = saveFile.getParentFile();
//	    		if(!parentPath.exists()){
//	    			parentPath.mkdirs();
//	    		}
//	    		try{
//	    			file.transferTo(saveFile);
//	    		}catch(Exception e){
//	    			this.logger.error("Save File Error!",e);
//	    			throw new BaseException("Save Attachment File Error!");
//	    		}
//	    		//保存数据库记录
//	    		attaVO = new AttachmentVO();
//	    		attaVO.setAttaId(this.txNewUUID());
//	    		attaVO.setAttaSetId(attaSetId);
//	    		attaVO.setFileNameOriginal(file.getOriginalFilename());
//	    		attaVO.setFileSavePath(relativePath);
//	    		attaVO.setFileSize(file.getSize());
//	    		attaVO.setFileType(suffix);
//	    		attaVO.setRemark("");
//	    		attaVO.setUploadTime(UtilDate.getCurrentTime());
//	    		attaVO.setUploadUserId(user.getUserId());
//	    		attaVO.setUploadUserName(user.getUserName());
//	    		this.getBaseDAO().insertMyBatisObj("framework.insertAtta", attaVO);
//	    	}
//	    }else{
//	    	throw new BaseException("Attachment root path should be assigned!");
//	    }
//		return attaVO;
//	}
       /**
	 * 删除附件
	 * @param attaId
	 * @param attaSetId
	 */
//	public void deleteAttachment(String attaId,String attaSetId){
//		if(attaId == null || attaId.trim().length() == 0){
//			return;
//		}
//		//保存文件至硬盘，改文件存储名称
//		String rootPath = "";
//		//获取字典表中，附件文件保存的根路径
//	    DictionaryVO dic = this.queryDictionaryOne(Constants.ATTACHMENT_ROOT_PATH);
//	    if(dic != null && dic.getDictionaryValue() != null && dic.getDictionaryValue().trim().length()>0){
//	        rootPath = dic.getDictionaryValue();
//	        QueryParam qp = QueryParam.getInstance2("framework.queryAttachmentById", attaId);
//		    AttachmentVO attaVO = (AttachmentVO)this.queryOne(qp);
//		    String savePath = rootPath+File.separator+attaVO.getFileSavePath();
//		    File file = new File(savePath);
//		    this.deleteMyBatisObj("framework.deleteAttachmentById", attaId);
//		    file.delete();
//	    }
//	}
}
