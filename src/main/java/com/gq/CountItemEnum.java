package com.gq;
/** 
* @className:CountItemEnum.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-9-21
*/
public enum CountItemEnum {

	
    /* 作业 */
    // 课程
    CourseHomeworkAllCount("courceHwCount", "result1", "课程作业总数"),
    CourseHomeworkMarkCount("courseHwMarkCount", "result2", "课程作业批改总数"),
    CourseHomeworkSubmitCount("courseHwSubmitCount", "result3", "课程作业提交总数"),
    CourseHomeworkUnsubmitCount("courseHwUnsubmitCount", "result4", "课程作业未提交总数"),
    CourseHomeworkRejectCount("courseHwRejectCount", "result5", "课程作业驳回总数"),
    // 教师
    TeacherHomeworkAllCount("teacherHwCount", "result1", "教师作业总数"),
    TeacherHomeworkSubmitedCount("teacherHwSubmit", "result2","教师作业已提交总数"),
    TeacherHomeworkUnsubmitCount("teacherHwUnsubmit", "result3", "教师作业未提交总数"),
    TeacherHomeworkMarkCount("teacherHwMark", "result4", "教师作业批改总数"),
    TeacherHomeworkRejectCount("teacherHwRejected", "result5", "教师作业驳回总数"),
    // 学生
    StudentHomeworkAllCount("studentHwCount", "result1", "学生作业总数"),
    StudentHomeworkSubmitCount("studentHwSubmit", "result2", "学生作业已提交总数"),
    StudentHomeworkUnsubmitCount("studentHwUnsubmit", "result3", "学生作业未提交总数"),
    StudentHomeworkRejectedCount("studentHwRejected", "result4", "学生作业被驳回总数"),
    StudentHomeworkMarkedCount("studentHwMarked", "result5", "学生作业已批改总数"),
    StudentHomeworkEvalCount("studentHwEval", "result6", "学生作业互评总数"),

    /* 测试 */
    // 课程
    CourseTestAllCount("courseTestAllCount", "result6", "课程测试总数"),
    CourseTestSubmitCount("courseTestSubmitCount", "result7", "课程测试已提交总数"),
    CourseTestUnsubmitCount("courseTestUnsubmitCount", "result8", "课程测试未提交总数"),
    // 教师
    TeacherTestAllCount("teacherTestCount", "result6", "教师测试总数"),
    TeacherTestMarkCount("teacherTestMark","result7","教师测试批改总数"),
    TeacherTestSubmitedCount("teacherTestSubmit","result8","教师测试已提交总数"),
    TeacherTestUnsubmitCount("teacherTestUnsubmit","result9","教师测试未提交总数"),
    // 学生
    StudentTestAllCount("studentTestCount", "result7", "学生测试总数"),
    StudentTestSubmitCount("studentTestSubmit", "result8", "学生测试已提交总数"),
    StudentTestUnsubmitCount("studentTestUnsubmit", "result9", "学生测试未提交总数"),

	/*答疑————课程*/
    CourseQestionTotalCount("courceAnswerCount", "result9", "课程下答疑总数"), 
    CourseQestionReplyCount("courceAnswerReply", "result10", "课程下已回答的答疑总数"), 
	
	/*答疑————教师*/
    TeacherQestionTotalCount("teacherAnswerCount", "result10", "教师所教课程的答疑总数"),
    TeacherQestionReplyCount("teacherAnswerReply", "result11", "教师回答的答疑总数"),
    TeacherQestionRecommendCount("teacherAnswerRecommend", "result12", "教师推荐的答疑总数"),
	
	/*答疑————学生*/
	StudentQestionTotalCount("studentAnswerCount", "result10", "学生提问总数"),
	StudentQestionReplyedCount("studentAnswerReplyed", "result11", "学生被回答的提问总数"),
	StudentQestionReplyCount("studentAnswerReply", "result12", "学生回答的提问总数"),
	StudentQestionReplyRecommendCount("studentAnswerReplyRecommendCount", "result25", "学生答疑回答被推荐为参考答案数"),
	
	/*笔记————课程*/
	CourseNoteTotalCount("courseNoteCount", "result11", "课程下笔记总数"),
	CourseNoteRecommendCount("courseNoteRecommendCount", "result12", "课程下被推荐笔记数"),
	
	/*笔记————教师*/
	TeacherNoteTotalCount("teacherNoteCount", "result13", "教师所教课程下笔记总数"),
	TeacherNoteRecommendCount("teacherNoteRecommendCount", "result14", "教师所教课程下被推荐笔记数"),
	
	/*笔记————学生*/
	StudentNoteTotalCount("studentNoteCount", "result13", "学生本课程下的笔记总数"),
	StudentNotePublicCount("studentNotePublicCount", "result14", "学生本课程下公开的笔记总数"),
	StudentNoteRecommendCount("studentNoteRecommendCount", "result15", "学生本课程下被推荐笔记数"),
	
	/*课程通知————教师*/
	TeacherNoticeTotalCount("teacherNoticeCount", "result15", "本课程下教师的课程通知总数"),
	
	/*课程资源统计————课程*/
	CourseResourceZLDownloadCount("downloadResource", "result13", "课程下载资料总数"),
	CourseResourceVideoCount("video", "result14", "课程视频总数"),
	CourseResourceImgTextCount("text", "result15", "课程图文总数"),
	CourseResourceCoursewareCount("courseware", "result16", "课程电子课件总数"),
	CourseResourceDocCount("doc", "result17", "课程文档总数"),
    CourseResourceLinkCount("link", "result18", "课程外部链接总数"),
    
    /*学生平均分————*/
    CourseStudentAverageScore("courseStudentAverageScore", "result19", "课程学生的平均分"),
    
    /*主题讨论—————课程*/
    CourseTopicTotalCount("courseTopicTotalCount", "result20", "课程主题讨论总数数"),
    
    /*主题讨论—————教师*/
    TeacherTopicTotalCount("teacherTopicTotalCount", "result16", "教师主题讨论数量"),
    TeacherTopicReplyCount("teacherTopicReplyCount", "result17", "教师回帖数量"),
    TeacherTopicGoodCount("teacherTopicGoodCount", "result18", "教师精华帖数量"),
    TeacherTopicBadCount("teacherTopicBadCount", "result19", "教师灌水帖数量"),
    
    /*主题讨论—————学生*/
    StudentJoinTopicTotalCount("studentJoinTopicTotalCount", "result16", "学生参与主题讨论个数"),
    StudentTopicReplyCount("studentTopicReplyCount", "result17", "学生回帖数"),
    StudentTopicGoodCount("studentTopicGoodCount", "result18", "学生精华帖数量"),
    StudentTopicBadCount("studentTopicBadCount", "result19", "学生灌水帖数量"),
	
    /* 新加统计项*/
    StudentTestRedoCount("studentTestRedo", "result20", "学生测试重做总数"),
    StudentTestConformedCount("studentTestConformed", "result21", "学生已确认成绩测试数量"),
    StudentTestUnconformedCount("studentTestUnconformed", "result22", "学生未确认成绩测试数量"),
    StudentTopicScore("studentTopicScore", "result23", "学生主题讨论积分"),
    StudentTopicTotalCount("studentTopicTotal", "result24", "学生主题讨论总数"),
    
    /*每门课程学时*/
    CourseFinishPercentCount("CourseFinishPercentCount", "result26", "学生选课已完成进度"),
	CourseFinishXSCount("CourseFinishXSCount", "result27", "学生选课已完成学时");
    
	
    private String code;
	private String name;
	private String note;
	
	private CountItemEnum(){
		
	}
	
	private CountItemEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	private CountItemEnum(String code, String name, String note) {
		this.code = code;
		this.name = name;
		this.note = note;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	enum Sign{
		geng,qiao
	}
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    	
    	System.out.println(CountItemEnum.CourseFinishXSCount.getCode());
    	System.out.println(CountItemEnum.CourseFinishXSCount.getName());
    	System.out.println(CountItemEnum.CourseFinishXSCount.getNote());

    	
    	
   }
}
